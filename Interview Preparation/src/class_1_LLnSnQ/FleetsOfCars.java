package class_1_LLnSnQ;

public class FleetsOfCars {

	public static void main(String[] args) {
		
		int[] pos = {90, 17, 62, 59, 82, 78};
		int[] speed = {3, 71, 45, 98, 74, 54};
		int target = 58;
		
		System.out.println("No. of Fleets = " + carFleet(target, pos, speed));
	}
	
	public static int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        
        for(int i = 0; i < n - 1; i++){
            for(int j = i; j < n - i - 1; j++){
                if(position[j] > position[j + 1]){
                    swap(position, j, j + 1);
                    swap(speed, j, j + 1);
                }
            }
        }
        
        display(position);
        display(speed);
        
        float[] time = new float[n];
        
        for(int i = 0; i < n; i++){
            time[i] = (float)((target - position[i]) * 1.0 / speed[i]);
        }
        
        display(time);
        
        int fleets = 0;
        float min = Integer.MIN_VALUE;
        
        for(int i = n - 1; i >= 0; i--){
            if(time[i] > min){
                min = time[i];
                fleets++;
            }
        }
        
        return fleets;
    }
	
	public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	public static void display(float[] arr) {
		for(float val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
	
	public static void display(int[] arr) {
		for(int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
}