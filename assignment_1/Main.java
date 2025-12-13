package assignment_1;

/**
 * Main
 * DataStructureAssignment1 لكل من:
 * - المصفوفات
 * - القائمة المتصلة المفردة
 * - القائمة المتصلة المزدوجة
 * - القائمة المتصلة الدائرية
 */
public class Main {

    public static void main(String[] args) {

        // ============================================
        //            اختبار أسئلة المصفوفات (Q1 - Q4)
        // ============================================

        System.out.println("===== Array Solutions Tests =====");

        int[] arr = {1, 2, 3, 4, 5};

        // Q1: اختبار استنساخ المصفوفة
        int[] cloned = DataStructureAssignment1.ArraySolutions.cloneArray(arr);
        System.out.println("المصفوفة الأصلية: ");
        printArray(arr);
        System.out.println("المصفوفة المستنسخة: ");
        printArray(cloned);

        // Q2: حذف عنصر عشوائي
        int[] removedRandom = DataStructureAssignment1.ArraySolutions.removeRandomElement(arr);
        System.out.println("بعد حذف عنصر عشوائي: ");
        printArray(removedRandom);

        // Q3: حذف عنصر محدد
        int[] removedSpecific = DataStructureAssignment1.ArraySolutions.removeSpecificElement(arr, 3);
        System.out.println("بعد حذف العنصر 3: ");
        printArray(removedSpecific);

        // Q4: عكس المصفوفة
        int[] arrReverse = {1, 2, 3, 4, 5};
        DataStructureAssignment1.ArraySolutions.reverseArray(arrReverse);
        System.out.println("المصفوفة بعد العكس: ");
        printArray(arrReverse);



        // ============================================
        //    اختبار القائمة المتصلة المفردة (Q5 - Q9)
        // ============================================

        System.out.println("\n===== Singly Linked List Tests =====");

        DataStructureAssignment1.SinglyLinkedList list1 = new DataStructureAssignment1.SinglyLinkedList();
        DataStructureAssignment1.SinglyLinkedList list2 = new DataStructureAssignment1.SinglyLinkedList();

        // تعبئة القائمتين
        list1.append(1);
        list1.append(2);
        list1.append(3);

        list2.append(4);
        list2.append(5);

        // Q5: دمج قائمتين
        System.out.println("دمج list1 و list2:");
        DataStructureAssignment1.SinglyLinkedList resultList =
                DataStructureAssignment1.SinglyLinkedList.concatenate(list1, list2);
        System.out.println(resultList);

        // Q6: تدوير القائمة لليمين
        resultList.rotateRight(2);
        System.out.println("بعد تدوير القائمة بمقدار 2:");
        System.out.println(resultList);

        // Q7 + Q8: البحث عن عنصر
        System.out.println("البحث عن 4 -> الفهرس: " + resultList.searchElement(4));

        // Q9: حذف عنصر عند فهرس معين
        resultList.removeAtPosition(2);
        System.out.println("بعد حذف العنصر عند الفهرس 2:");
        System.out.println(resultList);



        // ============================================
        //    اختبار القائمة المتصلة المزدوجة (Q10 - Q14)
        // ============================================

        System.out.println("\n===== Doubly Linked List Tests =====");

        DataStructureAssignment1.DoublyLinkedList dll = new DataStructureAssignment1.DoublyLinkedList();

        dll.append(1);
        dll.append(2);
        dll.append(2);
        dll.append(3);
        dll.append(3);
        dll.append(4);

        System.out.println("القائمة قبل حذف العناصر المكررة:");
        System.out.println(dll);

        // Q10: حذف التكرارات
        dll.removeDuplicates();
        System.out.println("بعد إزالة التكرارات:");
        System.out.println(dll);

        // Q11: الطباعة بالعكس
        System.out.println("طباعة من الخلف:");
        dll.traverseReverseAndPrint();

        // Q12: البحث عن عنصر
        System.out.println("البحث عن 3 -> الفهرس: " + dll.searchElement(3));



        // ============================================
        //    اختبار القائمة المتصلة الدائرية (Q15 - Q18)
        // ============================================

        System.out.println("\n===== Circular Linked List Tests =====");

        DataStructureAssignment1.CircularLinkedList cll = new DataStructureAssignment1.CircularLinkedList();

        cll.append(10);
        cll.append(20);
        cll.append(30);
        cll.append(40);

        System.out.println("القائمة الدائرية:");
        System.out.println(cll);

        // Q15: إدراج عنصر في موضع معين
        cll.insertAtPosition(15, 1);
        System.out.println("بعد إدراج 15 عند الفهرس 1:");
        System.out.println(cll);

        // Q16: حذف عنصر من فهرس محدد
        cll.deleteAtPosition(2);
        System.out.println("بعد حذف العنصر عند الفهرس 2:");
        System.out.println(cll);

        // Q17: البحث عن عنصر
        int idx = cll.searchElement(40);
        System.out.println("البحث عن 40 -> الفهرس: " + idx);

        // Q18: تقسيم القائمة إلى نصفين
        DataStructureAssignment1.CircularLinkedList[] halves = cll.splitIntoTwoHalves();
        System.out.println("النصف الأول:");
        System.out.println(halves[0]);
        System.out.println("النصف الثاني:");
        System.out.println(halves[1]);
    }

    // ============================
    // دالة مساعدة لعرض المصفوفات
    // ============================
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println("]");
    }
}
