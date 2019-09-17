import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.collections4.functors.IfClosure;
import org.apache.poi.ss.formula.functions.Fixed1ArgFunction;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.core.variable.Permutation;
import org.moeaframework.core.variable.RealVariable;
import org.moeaframework.problem.AbstractProblem;

public class ScheduleProblem extends AbstractProblem{
	
	public static final int TOTAL_SLOTS = 135;

	public ScheduleProblem() {
		super(TOTAL_SLOTS, 2, 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Solution newSolution() {
		// TODO Auto-generated method stub

		Solution newSolution = new Solution(numberOfVariables, numberOfObjectives, numberOfConstraints);

		for (int i=0; i< numberOfVariables; i++){
			newSolution.setVariable(i, EncodingUtils.newInt(0, 35));
		}


		return newSolution;
	}

	@Override
	public void evaluate(Solution solution) {
		// TODO Auto-generated method stub

		int[] slots = EncodingUtils.getInt(solution);
		int fitness1 = 0;
		int fitness2 = 0;

		Chromosome chromosome = new Chromosome();
		chromosome.init(slots);
		chromosome.calculateFitness();

		fitness1 = chromosome.getNoOfDirectClashes() + chromosome.getNoOfStudentsWith2ExamsPerDay();
		fitness2 = chromosome.getNoOfDaysWithOver1200StudentsAnySlot();

		solution.setObjective(0, fitness1);
		solution.setObjective(1, fitness2);

		int constraint1 = 10;
		int constraint2 = 0;

		solution.setConstraint(0, fitness1 <= constraint1 ? 0 : fitness1);
		solution.setConstraint(1, fitness2 == constraint2 ? 0 : fitness2);

		System.out.println("Fitness1: " + (int) solution.getObjective(0));
		System.out.println("Fitness2: " + (int) solution.getObjective(1));
	}

}
