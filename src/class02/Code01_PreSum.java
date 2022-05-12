package class02;

public class Code01_PreSum {
	public static void main(String[] args) {
		int[] nums = {1, 7, 3, 6, 5, 6};
		System.out.println(solution(nums));
	}
	//leetcode 724. 寻找数组的中心索引
	public static int solution(int[] nums) {
		int presum = 0;
		for (int num : nums) {
			presum += num;
		}
		int leftSum = 0;
		for (int i = 0; i < nums.length; i++) {
			int rightSum = presum - leftSum - nums[i];
			if (leftSum == rightSum) {
				return i;
			}
			leftSum += nums[i];
		}
		return -1;
	}


	public static class RangeSum1 {

		private int[] arr;

		public RangeSum1(int[] array) {
			arr = array;
		}

		public int rangeSum(int L, int R) {
			int sum = 0;
			for (int i = L; i <= R; i++) {
				sum += arr[i];
			}
			return sum;
		}

	}

	public static class RangeSum2 {

		private int[] preSum;
		//一维前缀和的公式：sum[i] = sum[i-1] + arr[i] ; sum是前缀和数组, arr是内容数组
		public RangeSum2(int[] array) {
			int N = array.length;
			preSum = new int[N];
			preSum[0] = array[0];
			for (int i = 1; i < N; i++) {
				preSum[i] = preSum[i - 1] + array[i];
			}
		}
		//[i, j]的区间和公式: interval [i, j] = sum[j] - sum[i - 1]
		public int rangeSum(int L, int R) {
			return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
		}

	}

}
