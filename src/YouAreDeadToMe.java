import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class YouAreDeadToMe {

    public static void main(String[] args) {
        FlatLightLaf.setup();

        String userGeneratedContestants = JOptionPane.showInputDialog(null, "Vilka ska delta? Separera med komma" +
                "\nExempel: Nils, Erik, Kalle, Konrad", "Vilka ska delta?", JOptionPane.QUESTION_MESSAGE).replace(" ", "");
        userGeneratedContestants = userGeneratedContestants.toLowerCase();
        LinkedList<String> contestants = new LinkedList<>(List.of(userGeneratedContestants.split(",")));
        Collections.shuffle(contestants);

        HashMap<String, String> murderer = new HashMap();
        for (int i = 0; i < contestants.size(); i++) {
            if (i == contestants.size() - 1)
                murderer.put(contestants.get(i), contestants.get(0));
            else
                murderer.put(contestants.get(i), contestants.get(i + 1));
        }

        while (true) {
            try {
                String contestant = JOptionPane.showInputDialog(null, "Vad heter du?", "Vad heter du?", JOptionPane.QUESTION_MESSAGE);
                if (contestant == null || contestant.equals("quit"))
                    break;
                contestant = contestant.toLowerCase();
                // If contestant doesnt exist
                if (!murderer.containsKey(contestant)) {
                    JOptionPane.showMessageDialog(null, "Ditt namn finns inte.\nDu kanske har stavat fel", "Namn finns inte", JOptionPane.WARNING_MESSAGE);
                    continue;
                }

                String toBeKilledLowercase = murderer.get(contestant);
                String toBeKilled = toBeKilledLowercase.substring(0, 1).toUpperCase();
                toBeKilled += toBeKilledLowercase.substring(1, toBeKilledLowercase.length());
                JOptionPane.showMessageDialog(null, "Du ska döda: " + toBeKilled);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

