package q_0146;

import java.util.HashMap;

/**
 * @author westboy
 * @since 2020/2/6
 */
public class SolutionV1 {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);

		cache.put(1, 1);
		System.out.println("cache.put(1, 1) ---> \t" + cache);

		cache.put(2, 2);
		System.out.println("cache.put(2, 2) ---> \t" + cache);

		int val = cache.get(1);  // 返回  1
		System.out.println("cache.get(1) \t---> \t"+ cache + " val:" + val);

		cache.put(3, 3);         // 该操作会使得密钥 2 作废
		System.out.println("cache.put(3, 3) --->\t" + cache);

		val = cache.get(2);      // 返回 -1 (未找到)
		System.out.println("cache.get(2) \t---> \t"+ cache + " val:" + val);

		cache.put(4, 4);         // 该操作会使得密钥 1 作废
		System.out.println("cache.put(4, 4) --->\t" + cache);

		val = cache.get(1);      // 返回 -1 (未找到)
		System.out.println("cache.get(1) \t---> \t"+ cache + " val:" + val);

		val = cache.get(3);      // 返回  3
		System.out.println("cache.get(3) \t---> \t"+ cache + " val:" + val);
		val = cache.get(4);      // 返回  4
		System.out.println("cache.get(4) \t---> \t"+ cache + " val:" + val);
	}



	static class LRUCache {
		static class Node {
			int k;
			int v;
			Node pre;
			Node next;

			Node(int k, int v) {
				this.k = k;
				this.v = v;
			}
		}
		private int size;
		private HashMap<Integer, Node> map;
		private Node head;
		private Node tail;

		LRUCache(int size) {
			this.size = size;
			map = new HashMap<>();
		}

		/**
		 * 添加元素
		 * 1. 元素存在，将元素移动到队尾
		 * 2. 不存在，判断链表是否满。如果满，则删除队首元素，放入队尾元素，删除更新哈希表；如果不满，放入队尾元素，更新哈希表
		 */
		public void put(int key, int value) {
			Node node = map.get(key);
			if (node != null) {
				//更新值
				node.v = value;
				moveNodeToTail(node);
			} else {
				Node newNode = new Node(key, value);
				//链表满，需要删除首节点
				if (map.size() == size) {
					Node delHead = removeHead();
					map.remove(delHead.k);
				}
				addLast(newNode);
				map.put(key, newNode);
			}
		}

		public int get(int key) {
			Node node = map.get(key);
			if (node != null) {
				moveNodeToTail(node);
				return node.v;
			}
			return -1;
		}

		public void addLast(Node newNode) {
			if (newNode == null) {
				return;
			}
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				//连接新节点
				tail.next = newNode;
				newNode.pre = tail;
				//更新尾节点指针为新节点
				tail = newNode;
			}
		}

		public void moveNodeToTail(Node node) {
			if (tail == node) {
				return;
			}
			if (head == node) {
				head = node.next;
				head.pre = null;
			} else {
				//调整双向链表指针
				node.pre.next = node.next;
				node.next.pre = node.pre;
			}
			node.pre = tail;
			node.next = null;
			tail.next = node;
			tail = node;
		}

		public Node removeHead() {
			if (head == null) {
				return null;
			}
			Node res = head;
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				head = res.next;
				head.pre = null;
				res.next = null;
			}
			return res;
		}

		@Override
		public String toString() {
			Node node = head;
			StringBuilder str = new StringBuilder("[");
			while (node != null) {
				str.append(node.k).append("-").append(node.v).append(",");
				node = node.next;
			}
			return str.substring(0, str.length() - 1) + "]";
		}
	}
}
