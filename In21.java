package offerPractice;

public class In21 {

	//��������˳��ʹ�������е�����λ��ż��ǰ�棺���ǿ���չ�Եؽⷨ
	private static void reorderOddEven(int[] nums){
		if(nums == null || nums.length <= 1) return; //ʵ���϶���ֻ��һ��Ԫ�ص����飬�Ѿ�����Ҫ�ٷ����ˣ�ֱ�ӷ��ؼ��ɣ������Լ��ټ�������
		ReorderSolution rsoe = new RecorderByOddEven();
		reorder(nums,rsoe); //ע��ÿ��ֻ��Ҫ�޸Ĵ���Ľӿ�ʵ���࣬�Ϳ���ʵ�ֹ��ܽ���Ĺ��ܣ����ֽ�������ģʽ�ǳ���Ҫ����
	}
	
	//ʵ�ֽ��Ǹ��������ڸ�������Ĺ���
	private static void reorderNegative(int[] nums){
		if(nums == null || nums.length <= 1) return; //ʵ���϶���ֻ��һ��Ԫ�ص����飬�Ѿ�����Ҫ�ٷ����ˣ�ֱ�ӷ��ؼ��ɣ������Լ��ټ�������
		ReorderSolution rsnp = new ReorderByNegative();
		reorder(nums, rsnp);
	}
	
	
	//�����������ͨ������Ľӿڶ���ʵ�֣���ʵ�ֵķ�ʽ��ͬ������������з���ķ�ʽҲ��ͬ��java�ýӿ�ʵ����C�еĺ���ָ��Ĺ���
	private static void reorder(int[] nums, ReorderSolution rs) {
		// TODO Auto-generated method stub
		if(rs == null){
			//��������Ľ��������null
			return; //����Nums��������κε��޸�
		}
		int start = 0;
		int end = nums.length - 1;
		while(start < end){
			//�����ｫ����Χ��rs�Ĳ��Էֳ�������
			while(start < end && rs.reorderBySolution(nums[start])){
				start++;
			}
			//�ҵ�start<end������µĵ�һ��ż��������Ϊstart
			while(start < end && !rs.reorderBySolution(nums[end])){
				end--;
			}
			//�ҵ�start<end������µĵ�һ������������Ϊend
			if(start < end){
				//���н�����������λ��ż����ǰ��
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
			}
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] nums1 = new int[]{1,2,3,4,5,6};
		int[] nums2 = new int[]{2,4,6,1,3,5};
		int[] nums3 = new int[]{1,3,5,2,4,6};
		int[] nums4 = null;
		int[] nums5 = new int[]{1};
		int[] nums6 = new int[]{2};
		reorderOddEven(nums1);
		reorderOddEven(nums2);
		reorderOddEven(nums3);
		reorderOddEven(nums4);
		reorderOddEven(nums5);
		reorderOddEven(nums6);*/
		int[] nums1 = new int[]{-1,2,-3,4,-5,6};
		int[] nums2 = new int[]{2,4,6,-1,-3,-5};
		int[] nums3 = new int[]{-1,-3,-5,2,4,6};
		int[] nums4 = null;
		int[] nums5 = new int[]{-1};
		int[] nums6 = new int[]{2};
		reorderOddEven(nums1);
		reorderOddEven(nums2);
		reorderOddEven(nums3);
		reorderOddEven(nums4);
		reorderOddEven(nums5);
		reorderOddEven(nums6);
	}

}

interface ReorderSolution{
	public boolean reorderBySolution(int num);
}

class RecorderByOddEven implements ReorderSolution{

	//�ж�һ�����Ƿ�Ϊ����������ǣ��򷵻�true,������ǣ��򷵻�false
	@Override
	public boolean reorderBySolution(int num) {
		// TODO Auto-generated method stub
		//����д�б�ı�׼������ν�����ֳ�������
		if((num & 0x01) == 1) return true; //ʹ��&���Ž���λ�����ʱ����ӿ��
		return false;
	}
	
}

class ReorderByNegative implements ReorderSolution{

	//����ķ���ʵ�����鰴���������з���
	@Override
	public boolean reorderBySolution(int num) {
		// TODO Auto-generated method stub
		if(num < 0) return true;
		return false;
	}
	
}
