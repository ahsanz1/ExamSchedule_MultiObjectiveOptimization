import org.moeaframework.Executor;
import org.moeaframework.core.NondominatedPopulation;
import org.moeaframework.core.Population;
import org.moeaframework.core.Solution;
import org.moeaframework.core.variable.EncodingUtils;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Data parsing and populating courses and students lists
		
		StudentsNcoursesDataStore studentsNcoursesDataStore =
                StudentsNcoursesDataStore.getInstance();
        studentsNcoursesDataStore.populateLists();
        studentsNcoursesDataStore.getCoursesOffered();
        studentsNcoursesDataStore.writeCourseNamesToFile();
        studentsNcoursesDataStore.findStudentsRegisteredInEachCourse();
        

        //MoEA implementation

        NondominatedPopulation result = new Executor()
				.withAlgorithm("NSGAII")
				.withProblemClass(ScheduleProblem.class)
				.withProperty("populationSize", 20)
                .withProperty("sbx.rate", 0.9)          //simulated binary crossover
				.withMaxEvaluations(1000)
				.run();

        //Printing non-dominated(fittest) solutions, in this case there's only 1 solution
		//that is better than rest of the solutions, so only that solution will pe printed.

        for (Solution solution : result){
        	double[] objectives = solution.getObjectives();
        	int[] x = new int[solution.getNumberOfObjectives()];

        	for (int i=0; i< solution.getNumberOfObjectives(); i++){
        		x[i] = (int) objectives[i];
			}

        	System.out.println("Non-Dominated Solution Objectives: " + Arrays.toString(x));
        	int[] slots = new int[solution.getNumberOfVariables()];

			for (int j =0; j < solution.getNumberOfVariables(); j++){
        		slots[j]= EncodingUtils.getInt(solution.getVariable(j));
			}

			System.out.println("Variables: " + slots.length + " " + Arrays.toString(slots));

			Chromosome chromosome = new Chromosome();
			chromosome.init(slots);
			chromosome.calculateFitness();
			chromosome.assignNamesToCourses();
			chromosome.printChromosome();
		}
        
	}


}
