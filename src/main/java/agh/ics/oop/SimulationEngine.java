package agh.ics.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class SimulationEngine implements IEngine {
    private AbstractWorldMap map;

    private MoveDirection[] directions;
    private List<Animal> animals;

    public SimulationEngine(MoveDirection[] directions, AbstractWorldMap map, Vector2d[] positions) {
        this.map = map;
        this.directions = directions;

        this.animals = new ArrayList<>();
        for (Vector2d position : positions) {
            Animal newAnimal = new Animal(map, position);
            if(newAnimal.isOnTheMap())
                this.animals.add(newAnimal);
        }
    }

    private JTextPane textPane;
    private Timer timer;
    private List<String> animationSteps;
    private JTextPane createSwingFrame(AbstractWorldMap map) {
        AbstractWorldMap.MapBounds bounds = map.getMapBounds();
        Vector2d windowSize = (bounds.upperRight.subtract(bounds.lowerLeft)
                .multiply(new Vector2d(2, 1))
                .add(new Vector2d(6,4)))
                .multiply(new Vector2d(16, 38));

        JFrame f = new JFrame();
        f.setTitle("Animals movement");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(windowSize.x, windowSize.y);

        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBounds(0,0,windowSize.x, windowSize.y);

        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 18);
        textPane.setFont(font);

        f.add(textPane);

        f.setLayout(null);
        f.setVisible(true);


        textPane.setText(this.animationSteps.get(0));

        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(animationSteps.size() == 0) {
                    timer.stop();
                    return;
                }

                textPane.setText(animationSteps.get(0));
                animationSteps.remove(0);
            }
        });
        timer.setRepeats(true);
        timer.start();
        return textPane;
    }

    public void run() {
        this.animationSteps = new ArrayList<>();
        this.animationSteps.add("Initial map\n" + map.toString());
        for (int i = 0; i < this.directions.length; i++) {
            this.animals.get(i%this.animals.size()).move(this.directions[i]);
            this.animationSteps.add("Move " + (i+1) + "/" + this.directions.length + "\n" + map.toString());
        }

        if(this.animationSteps.size() > 0)
            this.textPane = createSwingFrame(map);
    }
}
