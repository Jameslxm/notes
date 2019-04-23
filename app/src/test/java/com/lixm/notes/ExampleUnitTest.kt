package com.lixm.notes

import org.junit.Test
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.xml.datatype.DatatypeConstants.SECONDS






/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

//        val array = arrayOf(intArrayOf(3, -9, 6), intArrayOf(8, 0, 1), intArrayOf(11, 9, 8))
//        for (index in array.indices){
//            for (j in array[index].indices){
//                println("${index}行${j}列的数字："+array[index][j])
//            }
//        }
//        var str = "We are happy."
//        replaceBlank(str,str.length)
//        assertEquals(4, 2 + 2)
        //2、输入一链表的头结点,从尾到头反过来打印出每个结点的值
//        var  node1=  MySingleLinkList()
//        var  node2= MySingleLinkList()
//        var  node3= MySingleLinkList()
//        node1.data=1
//        node2.data=2
//        node3.data=4
//        node1.next=node2
//        node2.next=node3
//        revertList(node1)

        //3、
//        var preorder = intArrayOf( 1, 2, 4, 7, 3, 5, 6, 8)
//        var inorder = intArrayOf(4, 7, 2, 1, 5, 3, 8,6)
//        var construct = construct(preorder, inorder)
//        println("==="+construct?.value+";left:"+construct?.left?.value+";right:"+construct?.right?.value)

        //4、
//        printOneToNthDigits(3)

        //5
//        var head1 : ListNode = ListNode()
//        var head1_2 : ListNode = ListNode()
//        var head1_3 : ListNode = ListNode()
//        head1.value = 1
//        head1.next = head1_2
//        head1_2.value = 2
//        head1_2.next = head1_3
//        head1_3.value = 3
//        head1_3.next = null
//
//        var head2 : ListNode = ListNode()
//        var head2_2 : ListNode = ListNode()
//        var head2_3 : ListNode = ListNode()
//        head2.value = 4
//        head2.next = head1_2
//        head2_2.value = 5
//        head2_2.next = head1_3
//        head2_3.value = 6
//        head2_3.next = null
//        var mergeListNode  = merge2(head1, head2) as ListNode
//        println(";;"+ mergeListNode.value)


        val service = Executors.newScheduledThreadPool(4)
        service.schedule(Runnable { println(Thread.currentThread().name + "延迟三秒执行") }, 3, TimeUnit.SECONDS)
        service.scheduleAtFixedRate(
            Runnable { println(Thread.currentThread().name + "延迟三秒后每隔2秒执行") },
            3,
            2,
            TimeUnit.SECONDS
        )

    }

    class ListNode {
        internal var value: Int = 0
        internal var next: ListNode? = null
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     * 【使用的是递归的解法，不推荐，递归调用的时候会有方法入栈，需要更多的内存】
     *
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return 合并后的有序链表头
     */
    fun merge2(head1: ListNode?, head2: ListNode?): ListNode? {
        // 如果第一个链表为空，返回第二个链表头结点
        if (head1 == null) {
            return head2
        }

        // 如果第二个链表为空，返回第一个链表头结点
        if (head2 == null) {
            return head1
        }

        // 记录两个链表中头部较小的结点
        var tmp: ListNode = head1
        if (tmp.value < head2.value) {
            // 如果第一个链表的头结点小，就递归处理第一个链表的下一个结点和第二个链表的头结点
            tmp.next = merge2(head1.next, head2)
        } else {
            // 如果第二个链表的头结点小，就递归处理第一个链表的头结点和第二个链表的头结点的下一个结点
            tmp = head2
            tmp.next = merge2(head1, head2.next)
        }
        println("tmp:"+tmp.value)
        // 返回处理结果
        return tmp
    }

    /**
     *
     */
    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
     *
     * @param n 数字的最大位数
     */
    fun printOneToNthDigits(n: Int) {
        // 输入的数字不能为小于1
        if (n < 1) {
            throw RuntimeException("The input number must larger than 0")
        }
        // 创建一个数组用于打存放值
        val arr = IntArray(n)
        printOneToNthDigits(0, arr)
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。
     *
     * @param n   当前处理的是第个元素，从0开始计数
     * @param arr 存放结果的数组
     */
    fun printOneToNthDigits(n: Int, arr: IntArray) {

        // 说明数组已经装满元素
        if (n >= arr.size) {
            // 可以输出数组的值
            printArray(arr)
        } else {
            for (i in 0..9) {
                arr[n] = i
                println("====n:${n};i:${i}")
                printOneToNthDigits(n + 1, arr)
            }
        }
    }

    /**
     * 输入数组的元素，从左到右，从第一个非0值到开始输出到最后的元素。
     *
     * @param arr 要输出的数组
     */
    fun printArray(arr: IntArray) {
        // 找第一个非0的元素
        var index = 0
        while (index < arr.size && arr[index] == 0) {
            index++
        }

        // 从第一个非0值到开始输出到最后的元素。
        for (i in index until arr.size) {
            print(arr[i])
        }
        // 条件成立说明数组中有非零元素，所以需要换行
        if (index < arr.size) {
            println()
        }
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
     * 【第二种方法，比上一种少用内存空间】
     *
     * @param n 数字的最大位数
     */
    fun printOneToNthDigits2(n: Int) {
        // 输入值必须大于0
        if (n < 1) {
            throw RuntimeException("The input number must larger than 0")
        }

        // 创建一个长度为n的数组
        val arr = IntArray(n)
        // 为数组元素赋初始值
        for (i in arr.indices) {
            arr[i] = 0
        }

        // 求结果，如果最高位没有进位就一直进行处理
        while (addOne(arr) == 0) {
            printArray(arr)
        }
    }

    /**
     * 对arr表示的数组的最低位加1 arr中的每个数都不能超过9不能小于0，每个位置模拟一个数位
     *
     * @param arr 待加数组
     * @return 判断最高位是否有进位，如果有进位就返回1，否则返回0
     */
    fun addOne(arr: IntArray): Int {
        // 保存进位值，因为每次最低位加1
        var carry = 1
        // 最低位的位置的后一位
        var index = arr.size

        do {
            // 指向上一个处理位置
            index--
            // 处理位置的值加上进位的值
            arr[index] += carry
            // 求处理位置的进位
            carry = arr[index] / 10
            // 求处理位置的值
            arr[index] %= 10
        } while (carry != 0 && index > 0)

        // 如果index=0说明已经处理了最高位，carry>0说明最高位有进位，返回1
        return if (carry > 0 && index == 0) {
            1
        } else 0

        // 无进位返回0
    }

    /**
     * 二叉树节点类
     */
    class BinaryTreeNode {
        internal var value: Int = 0
        internal var left: BinaryTreeNode? = null
        internal var right: BinaryTreeNode? = null
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 树的根结点
     */
    fun construct(preorder: IntArray?, inorder: IntArray?): BinaryTreeNode? {
        // 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同
        return if (preorder == null || inorder == null || preorder.size != inorder.size || inorder.size < 1) {
            null
        } else construct(preorder, 0, preorder.size - 1, inorder, 0, inorder.size - 1)

    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历
     * @param ps       前序遍历的开始位置
     * @param pe       前序遍历的结束位置
     * @param inorder  中序遍历
     * @param is       中序遍历的开始位置
     * @param ie       中序遍历的结束位置
     * @return 树的根结点
     */
    fun construct(preorder: IntArray, ps: Int, pe: Int, inorder: IntArray, `is`: Int, ie: Int): BinaryTreeNode? {

        // 开始位置大于结束位置说明已经没有需要处理的元素了
        if (ps > pe) {
            return null
        }
        // 取前序遍历的第一个数字，就是当前的根结点
        val value = preorder[ps]
        var index = `is`
        // 在中序遍历的数组中找根结点的位置
        while (index <= ie && inorder[index] != value) {
            index++
        }

        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if (index > ie) {
            throw RuntimeException("Invalid input")
        }

        // 创建当前的根结点，并且为结点赋值
        val node = BinaryTreeNode()
        node.value = value

        // 递归构建当前根结点的左子树，左子树的元素个数：index-is+1个
        // 左子树对应的前序遍历的位置在[ps+1, ps+index-is]
        // 左子树对应的中序遍历的位置在[is, index-1]
        node.left = construct(preorder, ps + 1, ps + index - `is`, inorder, `is`, index - 1)
        // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
        // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
        // 右子树对应的中序遍历的位置在[index+1, ie]
        node.right = construct(preorder, ps + index - `is` + 1, pe, inorder, index + 1, ie)

        // 返回创建的根结点
        return node
    }

    public fun revertList( headnode : MySingleLinkList){
        if(headnode!=null){
            if(headnode.next!=null){
                revertList(headnode.next!!);
                println("======")
            }
        }
        System.out.println(headnode.data);
    }
    public class MySingleLinkList{
        var data : Int = 0
         var next : MySingleLinkList? = null
    }

    private fun replaceBlank(string: String, usedLength: Int){
        var numSpace = 0
        val arrayStr = string.toCharArray()
        for (i in arrayStr.indices) {
            if (arrayStr[i] == ' ') {
                numSpace++
            }
        }
        val newArrayStr = CharArray(arrayStr.size + 2 * numSpace)//确定替换空格后新数组大小
        var n = 0
        for (i in arrayStr.indices) {
            if (arrayStr[i] == ' ') {
                newArrayStr[n] = '%'
                n++
                newArrayStr[n] = '2'
                n++
                newArrayStr[n] = '0'
            } else
                newArrayStr[n] = arrayStr[i]
            n++
        }
        println(String(newArrayStr))
    }
}
