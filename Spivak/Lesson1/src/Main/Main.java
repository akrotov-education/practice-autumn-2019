package Main;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.print("Выбрать задание (1-30):");
		int task = scan.nextInt();
		
		switch(task)
		{
			case 1:
			{
				//Task1
				Task01.task();
				break;
			}
			
			case 2:
			{	
				//Task2
				Task02.task();
				break;
			}
			
			case 3:
			{		
				//Task3
				Task03.task();
				break;
			}
			
			case 4:
			{		
				//Task4
				Task04.task();
				break;
			}
			
			case 5:
			{		
				//Task5
				Task05.task();
				break;
			}
			
			case 6:
			{		
				//Task6
				Task06.task();
				break;
			}
			
			case 7:
			{		
				//Task7
				Task07.task();
				break;
			}
			
			case 8:
			{		
				//Task8
				Task08.task();
				break;
			}
			
			case 9:
			{		
				//Task9
				Task09.task();
				break;
			}
			
			case 10:
			{		
				//Task10
				Task10.task();
				break;
			}
			
			case 11:
			{		
				//Task11
				Task11.task();
				break;
			}
			
			case 12:
			{		
				//Task12
				Task12.task();
				break;
			}
			
			case 13:
			{		
				//Task13
				Task13.task();
				break;
			}
			
			case 14:
			{		
				//Task14
				Task14.task();
				break;
			}
			
			case 15:
			{		
				//Task15
				Task15.task();
				break;
			}
			
			case 16:
			{	
				//Task16
				Task16.task();
				break;
			}
			
			
			case 17:
			{	
				//Task17
				Task17.task();
				break;
			}
			
			
			case 18:
			{	
				//Task18
				Task18.task();
				break;
			}
			
			case 19:
			{		
				//Task19
				Task19.task();
				break;
			}
			
			
			case 20:
			{	
				//Task20
				Task20.task();
				break;
			}
			
			
			case 21:
			{	
				//Task21
				Task21.task();
				break;
			}
			
			
			case 22:
			{	
				//Task22
				Task22.task();
				break;
			}
			
			case 23:
			{	
				//Task23
				Task23.task();
				break;
			}
			
			case 24:
			{	
				//Task24
				Task24.task();
				break;
			}
			
			case 25:
			{	
				//Task25
				Task25.task();
				break;
			}
			
			case 26:
			{	
				//Task26
				Task26.task();
				break;
			}
			
			case 27:
			{	
				//Task27
				Task27.task();
				break;
			}
			
			case 28:
			{	
				//Task28
				Task28.task();
				break;
			}
			
			case 29:
			{	
				//Task29
				Task29.task();
				break;
			}
			
			case 30:
			{	
				//Task30
				Task30.task();
				break;
			}
			default:
				System.out.println("Error");
			scan.close();
		}
		System.out.println("Exit");
	}

}
