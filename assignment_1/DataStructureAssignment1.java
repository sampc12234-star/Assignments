package assignment_1;

import java.util.Arrays;
import java.util.Random;


public class DataStructureAssignment1 {

    // ===========================
    // حلول المصفوفات (Q1 - Q4)
    // ===========================
    public static class ArraySolutions {

        // Q1: كتابة برنامج لاستنساخ مصفوفة
        public static int[] cloneArray(int[] originalArray) {
            if (originalArray == null) return null;
            return originalArray.clone();
        }

        // Q2: حذف عنصر عشوائي من المصفوفة
        public static int[] removeRandomElement(int[] arr) {
            if (arr == null || arr.length == 0) return new int[0];
            Random rand = new Random();
            int indexToRemove = rand.nextInt(arr.length);

            int[] newArr = new int[arr.length - 1];
            int j = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i == indexToRemove) continue;
                newArr[j++] = arr[i];
            }
            return newArr;
        }

        // Q3: حذف عنصر محدد (أول ظهور) من المصفوفة
        public static int[] removeSpecificElement(int[] arr, int elementToRemove) {
            if (arr == null || arr.length == 0) return arr;
            int idx = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == elementToRemove) { idx = i; break; }
            }
            if (idx == -1) return arr; // العنصر غير موجود
            int[] newArr = new int[arr.length - 1];
            int j = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i == idx) continue;
                newArr[j++] = arr[i];
            }
            return newArr;
        }

        // Q4: عكس عناصر المصفوفة في مكانها
        public static void reverseArray(int[] arr) {
            if (arr == null) return;
            int i = 0, j = arr.length - 1;
            while (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++; j--;
            }
        }
    }

    // ===========================
    // القائمة المتصلة المفردة (Q5 - Q9)
    // ===========================
    public static class SLLNode {
        int data;
        SLLNode next;
        public SLLNode(int data) { this.data = data; this.next = null; }
    }

    public static class SinglyLinkedList {
        SLLNode head;

        public SinglyLinkedList() { this.head = null; }

        // دالة مساعدة: إضافة عنصر في نهاية القائمة
        public void append(int val) {
            SLLNode node = new SLLNode(val);
            if (head == null) { head = node; return; }
            SLLNode cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
        }

        // Q5: دمج قائمتين متصلتين (list1 + list2)
        public static SinglyLinkedList concatenate(SinglyLinkedList list1, SinglyLinkedList list2) {
            if (list1 == null) return list2;
            if (list1.head == null) { list1.head = (list2 == null ? null : list2.head); return list1; }
            SLLNode cur = list1.head;
            while (cur.next != null) cur = cur.next;
            if (list2 != null) cur.next = list2.head;
            return list1;
        }

        // Q6: تدوير القائمة إلى اليمين بمقدار k عناصر
        public void rotateRight(int k) {
            if (head == null || head.next == null || k <= 0) return;
            // حساب الطول والوصول للذيل
            SLLNode tail = head;
            int length = 1;
            while (tail.next != null) { tail = tail.next; length++; }
            k = k % length;
            if (k == 0) return;
            // جعل القائمة دائرية
            tail.next = head;
            // إيجاد الذيل الجديد
            int stepsToNewTail = length - k - 0;
            SLLNode newTail = head;
            for (int i = 1; i < stepsToNewTail; i++) newTail = newTail.next;
            SLLNode newHead = newTail.next;
            newTail.next = null;
            head = newHead;
        }

        // Q7 & Q8: البحث عن عنصر وإرجاع فهرسه أو -1
        public int searchElement(int value) {
            SLLNode cur = head;
            int idx = 0;
            while (cur != null) {
                if (cur.data == value) return idx;
                cur = cur.next; idx++;
            }
            return -1;
        }

        // Q9: حذف عنصر في موقع محدد (position)
        public boolean removeAtPosition(int position) {
            if (position < 0 || head == null) return false;
            if (position == 0) { head = head.next; return true; }
            SLLNode cur = head;
            for (int i = 0; cur != null && i < position - 1; i++) cur = cur.next;
            if (cur == null || cur.next == null) return false;
            cur.next = cur.next.next;
            return true;
        }

        // طباعة القائمة
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            SLLNode cur = head;
            while (cur != null) {
                sb.append(cur.data);
                if (cur.next != null) sb.append(" -> ");
                cur = cur.next;
            }
            return sb.toString();
        }
    }

    // ===========================
    // القائمة المتصلة المزدوجة (Q10 - Q14)
    // ===========================
    public static class DLLNode {
        int data;
        DLLNode prev, next;
        public DLLNode(int data) { this.data = data; this.prev = this.next = null; }
    }

    public static class DoublyLinkedList {
        DLLNode head, tail;
        public DoublyLinkedList() { head = tail = null; }

        // إضافة عنصر في نهاية القائمة
        public void append(int val) {
            DLLNode node = new DLLNode(val);
            if (head == null) { head = tail = node; return; }
            tail.next = node; node.prev = tail; tail = node;
        }

        // Q10: حذف العناصر المكررة
        public void removeDuplicates() {
            if (head == null) return;
            for (DLLNode cur = head; cur != null; cur = cur.next) {
                DLLNode runner = cur.next;
                while (runner != null) {
                    if (runner.data == cur.data) {
                        DLLNode next = runner.next;
                        DLLNode prev = runner.prev;
                        if (prev != null) prev.next = next;
                        if (next != null) next.prev = prev;
                        if (runner == tail) tail = prev;
                        runner = next;
                    } else {
                        runner = runner.next;
                    }
                }
            }
        }

        // Q11: الطباعة بالعكس من الذيل إلى الرأس
        public void traverseReverseAndPrint() {
            DLLNode cur = tail;
            StringBuilder sb = new StringBuilder();
            while (cur != null) {
                sb.append(cur.data);
                if (cur.prev != null) sb.append(" <- ");
                cur = cur.prev;
            }
            System.out.println(sb.toString());
        }

        // Q12: البحث عن عنصر في القائمة الثنائية
        public int searchElement(int value) {
            DLLNode cur = head;
            int idx = 0;
            while (cur != null) {
                if (cur.data == value) return idx;
                cur = cur.next; idx++;
            }
            return -1;
        }

        // طباعة القائمة
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            DLLNode cur = head;
            while (cur != null) {
                sb.append(cur.data);
                if (cur.next != null) sb.append(" <-> ");
                cur = cur.next;
            }
            return sb.toString();
        }
    }

    // ===========================
    // القائمة المتصلة الدائرية (Q15 - Q18)
    // ===========================
    public static class CLLNode {
        int data;
        CLLNode next;
        public CLLNode(int data) { this.data = data; this.next = null; }
    }

    public static class CircularLinkedList {
        CLLNode head;
        public CircularLinkedList() { head = null; }

        // إضافة عنصر في نهاية القائمة الدائرية
        public void append(int val) {
            CLLNode node = new CLLNode(val);
            if (head == null) { head = node; node.next = head; return; }
            CLLNode cur = head;
            while (cur.next != head) cur = cur.next;
            cur.next = node; node.next = head;
        }

        // Q15: إدراج عنصر في مكان محدد داخل القائمة الدائرية
        public void insertAtPosition(int data, int position) {
            CLLNode newNode = new CLLNode(data);
            if (position <= 0 || head == null) {
                if (head == null) { head = newNode; newNode.next = head; return; }
                CLLNode last = head;
                while (last.next != head) last = last.next;
                newNode.next = head; last.next = newNode; head = newNode; return;
            }
            CLLNode cur = head;
            for (int i = 0; i < position - 1; i++) {
                if (cur.next == head) break;
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }

        // Q16: حذف عنصر عند فهرس معين داخل القائمة الدائرية
        public boolean deleteAtPosition(int position) {
            if (head == null) return false;
            if (position == 0) {
                if (head.next == head) { head = null; return true; }
                CLLNode last = head;
                while (last.next != head) last = last.next;
                head = head.next; last.next = head; return true;
            }
            CLLNode cur = head;
            for (int i = 0; i < position - 1; i++) {
                if (cur.next == head) return false;
                cur = cur.next;
            }
            if (cur.next == head) return false;
            cur.next = cur.next.next;
            return true;
        }

        // Q17: البحث عن عنصر داخل القائمة الدائرية
        public int searchElement(int value) {
            if (head == null) return -1;
            CLLNode cur = head;
            int idx = 0;
            do {
                if (cur.data == value) return idx;
                cur = cur.next; idx++;
            } while (cur != head);
            return -1;
        }

        // Q18: تقسيم القائمة الدائرية إلى نصفين
        public CircularLinkedList[] splitIntoTwoHalves() {
            CircularLinkedList[] result = new CircularLinkedList[2];
            result[0] = new CircularLinkedList();
            result[1] = new CircularLinkedList();
            if (head == null) return result;

            CLLNode slow = head, fast = head;

            while (fast.next != head && fast.next.next != head) {
                fast = fast.next.next;
                slow = slow.next;
            }

            result[0].head = head;
            result[1].head = slow.next;

            slow.next = result[0].head;

            CLLNode tail2 = result[1].head;
            while (tail2.next != head) tail2 = tail2.next;
            tail2.next = result[1].head;

            return result;
        }

        // طباعة القائمة الدائرية
        @Override
        public String toString() {
            if (head == null) return "";
            StringBuilder sb = new StringBuilder();
            CLLNode cur = head;
            do {
                sb.append(cur.data);
                cur = cur.next;
                if (cur != head) sb.append(" -> ");
            } while (cur != head);
            return sb.toString();
        }
    }
}
