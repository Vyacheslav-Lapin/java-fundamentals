package com.epam.courses.java.fundamentals.oop.TasksFromPDF.Task6;

public class NuclearSubmarine {
    private SubmarineEngine engine;
    private boolean isEngineWorking;

    public NuclearSubmarine() {
        engine = new SubmarineEngine();
    }


    private void startEngine() {
        engine.start();
    }

    private void stopEngine() {
        engine.stop();
    }

    public boolean isEngineWorking() {
        return isEngineWorking;
    }


    private class SubmarineEngine {
        private void start() {
            if (!NuclearSubmarine.this.isEngineWorking) {
                NuclearSubmarine.this.isEngineWorking = true;

                System.out.println("Submarine engine started.");
            }
        }

        private void stop() {
            if (NuclearSubmarine.this.isEngineWorking) {
                NuclearSubmarine.this.isEngineWorking = false;
                System.out.println("Submarine engine stopped.");
            }
        }
    }
}
