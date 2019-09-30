import java.lang.ArrayIndexOutOfBoundsException;
public class DoublyLinkedList<Object>{
    private int length;
    private ListNode<Object> root,end;

    public DoublyLinkedList(){
        length=0;
        root=null;
        end=null;
    }



    public ListNode<Object>getNodeAt(int pos) {
        if((pos>=length||pos<0)&&length!=0)
            throw new ArrayIndexOutOfBoundsException();
        else if(pos!=0&&length==0)
            throw new ArrayIndexOutOfBoundsException();
        else {
            int counter=0;
            ListNode<Object> ln =null;
            for(ListNode<Object> i=root; i!=null; i=i.getNext()) {
                if(counter==pos) {
                    ln=i;
                    break;
                }
                counter++;
            }
            return ln;
        }
    }
    public void sort(){
		for(ListNode<Object> i=root; i!=null; i=i.getNext()) {
			ListNode<Object> lowest=i;
			for(ListNode<Object> next=i.getNext(); next!=null; next=next.getNext()) {
				if((lowest.getValue()instanceof Comparable&&next.getValue()instanceof Comparable)&&((Comparable)lowest.getValue()).compareTo((Comparable)next.getValue())>0) {
					lowest=next;
				}
			}
			Object tempnumber = i.getValue();
			i.setValue(lowest.getValue());
			lowest.setValue(tempnumber);
		}


    }

    public ListNode<Object> getRoot(){
        return root;
    }

    public int size(){
        return length;
    }

    public void clear(){
        root=null;
        end=null;
        length=0;
    }

    public boolean contains(Object obj){
        boolean cont =false;
        for(ListNode<Object> i=root; i!=null; i=i.getNext()) {
            if(i.getValue().equals(obj)) {
                cont=true;
                break;
            }
        }
        return cont;
    }

    public void add(int pos, Object obj) {
		if(length!=0&&(pos<0||pos>length))
			throw new ArrayIndexOutOfBoundsException();
		else if(pos==length) {
			add(obj);
		}
		else if(pos<length&&length!=0){
			ListNode<Object> listNode=new ListNode(obj);
			ListNode<Object> tempNode =root.getPrevious();
			ListNode<Object> prevNode =root.getPrevious();
			int counter=0;
			for(ListNode<Object> i=root; i!=null; i=i.getNext()) {
				if(counter==pos&&pos==length-2) {
					end=i.getNext();
					end.setPrevious(i);
					end.setNext(null);
				}
				counter++;

			}
			counter=0;
			for(ListNode<Object> i=root; i!=null; i=i.getNext()) {
				if(counter==pos-1) {
					prevNode=i;
					tempNode=i.getNext();
					break;
				}
				counter++;
			}
			if(pos!=0) {
				prevNode.setNext(listNode);
				listNode.setPrevious(prevNode);
				listNode.setNext(tempNode);
				tempNode.setPrevious(listNode);
			}
			else if(pos==0) {
				listNode.setPrevious(null);
				listNode.setNext(root);
				root.setPrevious(listNode);
				root=listNode;
			}

			length++;
		}

    }

    public void add(Object obj){
        ListNode<Object> listNode=new ListNode(obj);
        if(length==0) {
            root=new ListNode(obj);
            root.setNext(null);
            root.setPrevious(null);
            end=root;
        }
        else {
            end.setNext(listNode);
            listNode.setPrevious(end);
            end=listNode;
        }
        length++;
    }



    public int get(int pos) {
        if((pos>=length||pos<0)&&length!=0)
            throw new ArrayIndexOutOfBoundsException();
        else if(pos!=0&&length==0)
            throw new ArrayIndexOutOfBoundsException();
        else {
            int counter=0;
            ListNode<Object> ln=null;
            for(ListNode<Object> i=root; i!=null; i=i.getNext()) {
                if(counter==pos) {
                    ln=i;
                    break;
                }
                counter++;
            }
            return Integer.parseInt(String.valueOf(ln.getValue()));
        }



    }

    public boolean isEmpty(){
        return root==null||length==0;
    }

    public void getNext(){
        if(root.getNext()==end) {
            root=end;
        }
        else if(root.getNext()==null)
            root=null;
        else
            root=root.getNext();
        length--;
    }

    public void remove(int pos){
        if((pos>=length||pos<0)&&length!=0)
            throw new ArrayIndexOutOfBoundsException();
        else if(pos!=0&&length==0)
            throw new ArrayIndexOutOfBoundsException();
        else if(pos==0&&length==0) {
            root=null;
            length--;
        }
        else if(pos==0&&length==1) {
            root=null;
            length=0;
        }
        else if(pos==0&&length>1) {
            root=root.getNext();
            root.setPrevious(null);
            length--;
        }
        else if(pos==length-1) {
            end=end.getPrevious();
            end.setNext(null);
            length--;
        }
        else if(pos>0&&pos<length-1&&length!=0) {
            int counter=1;
            ListNode<Object> previous =root.getPrevious();
            ListNode<Object> after =root.getPrevious();
            for(ListNode<Object> i=root.getNext(); i!=null; i=i.getNext()) {
                if(pos==counter) {
                    previous =i.getPrevious();
                    after =i.getNext();
                    break;
                }
                counter++;
            }
            previous.setNext(after);
            after.setPrevious(previous);
            length--;
        }
    }

    public String toString(){
        String output="[";
        for(ListNode<Object> i=root; i!=null; i=i.getNext()){
            if(i.getNext()==null) {
                output+=String.valueOf(i.toString());
            }
            else {
                output+=String.valueOf(i.toString())+", ";
            }
        }
        output+="]";
        return output;
    }

    public String toReversedString(){
        String output="[";
        if(length!=0) {
            for(ListNode<Object> i=end; i!=null; i=i.getPrevious()){
                if(i.getPrevious()==null) {
                    output+=String.valueOf(i.toString());
                }
                else {
                    output+=String.valueOf(i.toString())+", ";
                }
            }
        }
        output+="]";
        return output;
    }

    public ListNode<Object> getEnd(){
        return end;
    }

    public class ListNode<Object> {

        private Object object;
        private ListNode<Object> previous,next;

        public ListNode(Object object){
            this.object=object;
            previous=null;
            next=null;
        }

        public void setValue(Object object){
            this.object=object;
        }

        public Object getValue(){
            return object;
        }

        public ListNode<Object> getPrevious(){
            return previous;
        }

        public ListNode<Object> getNext(){
            return next;
        }

        public void setPrevious(ListNode<Object> previous) {
            this.previous=previous;
        }

        public void setNext(ListNode<Object> next){
            this.next=next;
        }

        public boolean hasNext(){
            return next!=null;
        }

        public boolean hasPrevious(){
            return previous!=null;
        }

        public String toString(){
            return String.valueOf(object);
        }

    }




}