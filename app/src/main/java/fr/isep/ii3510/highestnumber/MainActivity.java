package fr.isep.ii3510.highestnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    /**
     * Here, I am simply creating attributes (or variables)
     * that will be useful in the rest of the program
     */
    private Button leftButton, rightButton;
    private TextView scoreTextView;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Remember, the method findViewById() creates the link between
         * a Widget (or something displayed on the screen) and a Java object
         */
        leftButton = findViewById(R.id.left_button);
        rightButton = findViewById(R.id.right_button);
        scoreTextView = findViewById(R.id.score_text_view);

        /**
         *
         */
        generateRandomNumbers();
    }

    /**
     * Generate two different random numbers and assign their values to the two buttons
     */
    private void generateRandomNumbers() {
        /**
         * 1. We start by generating a random number between [0, 99]
         * 2. We generate another random number between [0, 99]
         * 3. We keep generating this other random number while randomNumber == anotherRandomNumber
         * 4. When the while loop is over, we set the `text` attribute of the two Buttons to
         *    these randomly generated numbers.
         */
        Random random = new Random();

        int randomNumber = random.nextInt(100);
        int anotherRandomNumber;
        do {
            anotherRandomNumber = random.nextInt(100);
        } while (anotherRandomNumber == randomNumber);

        leftButton.setText(String.valueOf(randomNumber));
        rightButton.setText(String.valueOf(anotherRandomNumber));
    }

    public void buttonClicked(View view) {
        Button buttonClicked = (Button) view;
        int buttonClickedValue = Integer.parseInt(buttonClicked.getText().toString());

        int leftValue = Integer.parseInt(leftButton.getText().toString());
        int rightValue = Integer.parseInt(rightButton.getText().toString());

        // I have refactored this condition to shorten the code
        if ((leftValue > rightValue && leftValue == buttonClickedValue) ||
                (rightValue > leftValue && rightValue == buttonClickedValue)) {
            score++;
            scoreTextView.setText("Score: " + score);
        }
        // Because we did not do anything when the user was wrong, we can simply remove the `else` branch


        generateRandomNumbers();
    }
}