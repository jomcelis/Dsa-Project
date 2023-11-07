package User_Hompage;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LNode<Object> {
    Object data;
    LNode<Object> next;
    private LNode<Object> head;
    private int autoIncrementer = 1;

    public void error_message(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }


    public boolean isEmpty() {
        return head == null;
    }

    public void addAtFirst(Object value) {
        LNode<Object> newNode = new LNode<>();
        if (isEmpty()) {
            ZoneId manilaZone = ZoneId.of("Asia/Manila");
            ZonedDateTime manilaTime = ZonedDateTime.of(LocalDateTime.now(), manilaZone);
            String formattedTime = manilaTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            newNode.data = (Object) ((autoIncrementer++) +". "+"\"" + value + "\" "+ " " + formattedTime); // Concatenate the Manila time to the value
            newNode.next = null;
            head = newNode;
        } else {
            ZoneId manilaZone = ZoneId.of("Asia/Manila");
            ZonedDateTime manilaTime = ZonedDateTime.of(LocalDateTime.now(), manilaZone);
            String formattedTime = manilaTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            newNode.data = (Object) ((autoIncrementer++) +". "+"\"" + value + "\" "+ " " + formattedTime); // Concatenate the Manila time to the value
            newNode.next = head;
            head = newNode;
        }
    }

    public String traverse() {
        if (isEmpty()) {
            return "List is empty";
        } else {
            String hold = "";
            LNode<Object> link = head;
            while (link != null) {
                hold += link.data + "\n";
                link = link.next;
            }
            return hold;
        }
    }

    public void addAtLast(Object value) {
        if (isEmpty()) {
            addAtFirst(value);
        } else {
            LNode<Object> link = head;
            while (link.next != null) {
                link = link.next;
            }
            LNode<Object> newNode = new LNode();
            ZoneId manilaZone = ZoneId.of("Asia/Manila");
            ZonedDateTime manilaTime = ZonedDateTime.of(LocalDateTime.now(), manilaZone);
            String formattedTime = manilaTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            newNode.data = (Object) ((autoIncrementer++) + " " + " \"" + value + "\" "  + " " + formattedTime); // Concatenate the Manila time to the value
            newNode.next = null;
            link.next = newNode;
        }
    }

    public int currentSize() {
        int counter = 1;
        if (isEmpty()) {
            error_message("List is empty");
        } else {
            LNode<Object> link = head;
            while (link.next != null) {
                link = link.next;
                counter++;
            }
        }
        return counter;
    }

    public void addAtPosition(Object value, int position) { //Jomari Q. Celis
        if (isEmpty()) {
            error_message("List is Empty. Node is added at the Beginning");
            addAtFirst(value); // Blank 1
        } else if (position == 0) {
            error_message("Node is added at the Beginning");
            addAtFirst(value);//blank 2
        } else if (position < 0 || position > currentSize()) { //Blank3
            error_message(position + " is NOT valid");
        } else {
            LNode<Object> visit, link;
            visit = link = head; //Blank 4

            int ctr = 1;
            while (ctr != position) {
                visit = visit.next; //Blank5
                ctr++;
            }
            while (link.next != visit) {
                link = link.next;//Blank6
            }
            LNode<Object> newNode = new LNode();
            newNode.next = visit;     //Blank7
            newNode.data = value;     //Blank8
            link.next = newNode;
        }
    }

    public void deleteAtFirst(){
        if(isEmpty()){
            error_message("Deleting Not Allowed. Linked list is empty.");
        }else{
            autoIncrementer--;
            LNode<Object> link = head;
            head=link.next;
            System.out.println("Deleting is successful");
        }
    }

    public void deleteAtLast() {
        if (isEmpty()) {
            error_message("Deleting Not Allowed. Linked list is empty.");
        } else if (head.next == null) {
            head = null;
            System.out.println("Deleting is Successful");
        } else {
            LNode<Object> visit = head;
            LNode<Object> link = null;
            while (visit.next != null) {
                link = visit;
                visit = visit.next;
            }
            assert link != null;
            link.next = null;
            System.out.println("Deleting is Successful");
        }
    }


    public void deleteAtPosition(int position) { //Jomari Q. Celis
        if (isEmpty()) {
            error_message("The list is empty. Try to add a value");
        } else if (position == 0) {
            deleteAtFirst();
        } else if (position < 0 || position >= currentSize()) {
            System.err.println("Position is NOT valid");

        } else {
            LNode<Object> visit, link, pointer;
            visit = link = pointer = head;
            int ctr = 0;
            while (ctr != position - 1) //Blank 1
            {
                visit = visit.next; //Blank 2
                ctr++;
            }
            while (link.next != visit) //Blank3
            {
                link = link.next; //Blank4
            }
            ctr++; //Blank 5
            while (ctr != position) { //Blank6
                pointer = pointer.next;
                ctr++; //Blank7
            }
            link.next = pointer.next;         //Blank 8
        }
    }

    public Object getFirst(){
        if(isEmpty()){
            error_message("List is Empty.");
            return null;
        } else {
            return head.data;
        }
    }

    public Object getLast() {

        LNode<Object> last =head;
        while(last.next!=null){
            last=last.next;
        }
        return  last.data;
    }



    public void addInMiddle(Object value) {
        if (isEmpty()) {
            error_message("List is Empty. Cannot add in the middle.");
            return;
        }
        int size = currentSize();
        int middle = size / 2;
        addAtPosition(value, middle);
    }

    public void deleteInMiddle() {
        if (isEmpty()) {
            error_message("List is Empty. Cannot delete from the middle.");
            return;
        }
        int size = currentSize();
        int middle = size / 2;
        deleteAtPosition(middle);
    }

    public void deleteValue(Object value) {
        if (isEmpty()) {
            error_message("List is Empty. Cannot delete the value.");
            return;
        }
        int index = indexAt(value);
        if (index != -1) {
            deleteAtPosition(index);
        } else {
            System.err.println("Value does not exist in the linked list.");
        }
    }

    public int indexAt(Object value) {
        if (isEmpty()) {
            error_message("List is Empty. Value does not exist.");
            return -1;
        }
        LNode<Object> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public Object get(int position) {
        if (isEmpty()) {
            error_message("List is Empty.");
            return null;
        }
        if (position < 0 || position >= currentSize()) {
            error_message("Position is not valid.");
            return null;
        }
        LNode<Object> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return (Object) current.data;
    }


}//class



