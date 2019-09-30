public class DoublyMain{

	public static void main(String[]args) {
		DoublyLinkedList<Integer>list=new DoublyLinkedList<>();
		for(int i=0; i<30; i++) {
			list.add((int)(Math.random()*1000)+1);
		}
		System.out.println("Original: "+list+"\n");
		System.out.println("Reversed: "+list.toReversedString()+"\n");
		System.out.println("Length: "+list.size()+"\n");
		int sum=0;
		int evensum=0;
		int oddsum=0;
		int pos=0;
		DoublyLinkedList<Integer>sub=new DoublyLinkedList<>();
		while(!list.isEmpty()) {
			if(pos%2==0) {
				int num=list.getRoot().getValue();
				evensum+=num;
				sum+=num;
				sub.add(num);
				list.getNext();
			}
			else {
				int num=list.getRoot().getValue();
				oddsum+=num;
				sum+=num;
				sub.add(num);
				list.getNext();
			}

			pos++;
		}
		list=sub;
		System.out.println("Average: "+((double)sum)/list.size());
		System.out.println("\n\n");
		System.out.println("Odd Average: "+((double)oddsum)/(list.size()/2));
		System.out.println("\n\n");
		System.out.println("Even Average: "+((double)evensum)/(list.size()/2));
		System.out.println("\n\n");
		sub=new DoublyLinkedList<>();
		DoublyLinkedList<Integer>sub2=new DoublyLinkedList<>();
		while(!list.isEmpty()) {
			int num=list.getRoot().getValue();
			sub2.add(num);
			list.getNext();
			if(num%2==1) {
				sub.add(num);
			}
		}
		list=sub2;
		while(!sub.isEmpty()) {
			list.add(sub.getRoot().getValue());
			sub.getNext();
		}
		System.out.println("Duplicated Odd Values: "+list);
		System.out.println("\n\n");
		sub2=new DoublyLinkedList<>();
		while(!list.isEmpty()) {
			int num=list.getRoot().getValue();
			if(num%4!=0) {
				sub2.add(num);
			}
			list.getNext();
		}
		list=sub2;
		System.out.println("Numbers Divisible by 4 Removed: "+list);
		System.out.println("\n\n");
		list.add(3,45454);
		System.out.println("45454 added into 4th position: "+list);
		System.out.println("\n\n");
		for(int i=0; i<list.size(); i++) {
			int low=list.get(i);
			pos=i;
			for(int j=i; j<list.size(); j++) {
				if(list.get(j)<low) {
					low=list.get(j);
					pos=j;
				}
			}
			list.getNodeAt(pos).setValue(list.get(i));
			list.getNodeAt(i).setValue(low);
		}
		System.out.println("Sorted List: "+list);
		System.out.println("\n\n");
		sub2=new DoublyLinkedList<>();
		if(list.size()%2==1)
			list.remove(list.size()-1);
		if(list.size()%2==0) {
			pos=0;
			int size=list.size();
			while(!list.isEmpty()) {
				int num=list.getRoot().getValue();
				if(pos==size/2-1) {
					int num2=list.getRoot().getNext().getValue();
					double median=(num+num2)/2.0;
					System.out.println("Median: "+median+"\nValue before: "+num+"\nValue after: "+num2);
					break;
				}
				sub2.add(num);
				list.getNext();
				pos++;
			}
		}
		else {
			pos=1;
			int size=list.size();
			while(!list.isEmpty()) {
				int median,prev,after;
				median=0;
				after=0;
				prev=list.getRoot().getValue();
				if(list.getRoot().getNext()!=null) {
				   median=list.getRoot().getNext().getValue();
				   if(list.getRoot().getNext().getNext()!=null)
						after=list.getRoot().getNext().getNext().getValue();
					else {
						after=median;
					}
				}
				else {
					median=prev;
					after=median;
				}
				if(pos==size/2-1) {
					System.out.println("Median: "+median+"\nValue before: "+prev+"\nValue after: "+after);
					break;
				}
				sub2.add(prev);
				list.getNext();
				pos++;
			}
		}
		list=sub2;

}




}