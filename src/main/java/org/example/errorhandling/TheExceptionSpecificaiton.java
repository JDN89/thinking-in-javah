package org.example.errorhandling;

import java.io.IOException;

public class TheExceptionSpecificaiton {
}

class Example {

    // Reads data from a file, and throws IOException
    public void readDataFromFile(String filePath) throws IOException {
        // ... code that might throw IOException ...
    }

    // Option 1: Catch the exception
    public void handleLocally(String filePath) {
        try {
            readDataFromFile(filePath);
        } catch (IOException e) {
            // Handle the exception here, e.g., print an error message
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Option 2: Propagate the exception
    public void propagateException(String filePath) throws IOException {
        readDataFromFile(filePath);
    }
}

//BOOK EXAMPLE

class DynamicFieldsException extends Exception {
}

class DynamicFields {
    private Object[][] fields;

    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++)
            fields[i] = new Object[]{null, null};
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++)
            if (id.equals(fields[i][0]))
                return i;
        return -1;
    }

    private int
    getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if (fieldNum == -1)
            throw new NoSuchFieldException();
        return fieldNum;
    }

    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++)
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
// No empty fields. Add one:
        Object[][] tmp = new Object[fields.length + 1][2];
        for (int i = 0; i < fields.length; i++)
            tmp[i] = fields[i];
        for (int i = fields.length; i < tmp.length; i++)
            tmp[i] = new Object[]{null, null};
        fields = tmp;
// Recursive call with expanded fields:
        return makeField(id);
    }

    public Object
    getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(String id, Object value)
            throws DynamicFieldsException {
        if (value == null) {
// Most exceptions don’t have a "cause" constructor.
// In these cases you must use initCause(),
// available in all Throwable subclasses.
            DynamicFieldsException dfe = new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber = hasField(id);
        if (fieldNumber == -1)
            fieldNumber = makeField(id);
        Object result = null;
        try {
            result = getField(id); // Get old value
        } catch (NoSuchFieldException e) {
// Use constructor that takes "cause":
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try {
            df.setField("d", "A value for d");
            df.setField("number", 47);
            df.setField("number2", 48);
            System.out.println(df);
            df.setField("d", "A new value for d");
            df.setField("number3", 11);
            System.out.println("df: " + df);
            System.out.println("df.getField(\"d\") : " + df.getField("d"));
            Object field = df.setField("d", null); // Exception
        } catch (NoSuchFieldException e) {
            e.printStackTrace(System.out);
        } catch (DynamicFieldsException e) {
            e.printStackTrace(System.out);
        }
    }
}