package org.example.functionalinterfaces.buttonEvent;

public class Main {
    public static void main(String[] args) {
        ButtonFrame buttonFrame = new ButtonFrame();
        buttonFrame.setButtonClickListener(new ButtonClickListener() {
            @Override
            public void onButtonClick() {
                System.out.println("Button was clicked!");
            }
        });
    }
}