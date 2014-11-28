import java.util.*;
public class Heuristic {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{	
		Scanner scanner2 = new Scanner( System.in);
		Day[] freedays = Day.freetimes(scanner2);
		System.out.print(freedays.length);
		//Proof of concept code here
		
		
		Scanner scanner1 = new Scanner( System.in );
	
		int value =1;

		Exercise exercise;
		Exercise[] exercises;
		
		//while (value != 0)
		//{	
			System.out.print("\nMake how many exercises? (0 terminates):\n");
			value = scanner1.nextInt();
			exercises = new Exercise[value];
			for (int i = 0; i < value; i ++)
			{
				exercise = Exercise.genex();
				System.out.print(exercise.name+", "+exercise.comptime+"\n");
				exercises[i] = exercise;
				
			}
			Workout[] workouts = algorithm(freedays, exercises);
			
	
			
			//print workouts[0].
		//}
		
		//System.out.print(exercises[1].mgroup);
		

		scanner1.close();
		scanner2.close();

		
		
	}
	
	static Workout[] algorithm(Day[] days, Exercise[] exercises)
	{
		Workout[] workouts = new Workout[days.length];
		
		for (int i = 0; i < days.length; i ++)
		{
			workouts[i] = new Workout(days[i].freetime, exercises.length);
		}
		
		Arrays.sort(exercises);
		
		for (int i = 0; i < exercises.length; i++)
		{
			for(int j = 0; j < workouts.length; j++)
			{
				if (workouts[j].time + exercises[i].comptime < workouts[j].maxtime)
				{
					workouts[j].exercises[workouts[j].count] = exercises[i];
					workouts[j].count++;
					workouts[j].time += exercises[i].comptime;
					break;
				}
				
			}
		}

		System.out.print(workouts[0].time);

		
		
		
		return workouts;
	}
	

}
 

