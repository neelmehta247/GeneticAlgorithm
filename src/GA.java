/**
 * Created by neel on 29/08/15 at 1:39 PM.
 */
public class GA {

    public static void main(String[] args) {
        int geneLength = 40;

        Individual.setDefaultGeneLength(geneLength);

        String goalString = "";
        for (int i = 0; i < geneLength; i++) {
            goalString += Math.round(Math.random());
        }

        // Set a candidate solution
        FitnessCalc.setSolution(goalString);

        // Create an initial population
        Population myPop = new Population(6, true);

        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
        while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness() + " Gene: " + myPop.getFittest());
            myPop = Algorithm.evolvePopulation(myPop);
        }
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        System.out.println(myPop.getFittest());

    }
}
