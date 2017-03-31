import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		String s1 = doWork("foo/./bar");
		System.out.println(s1);
		String s2 = doWork("foo/bar/../baz");
		System.out.println(s2);
		String s3 = doWork("../foo/bar");
		System.out.println(s3);
	}

	public static String doWork(String path) {
		String res = "";
		Deque<String> deque = new LinkedList<>();
		Set<String> passSet = new HashSet<>(Arrays.asList("..", ".", ""));

		// edit the deque according conditions
		for (String dir : path.split("/")) {
			if (dir.equals("..") && !deque.isEmpty()) {
				deque.pop();
			} else if (!passSet.contains(dir)) {
				deque.push(dir);
			}
		}

		// make proper view
		for (String str : deque) {
			res = "/" + str + res;
		}

		if (res.isEmpty()) {
			return "/";
		} else {
			return res;
		}
	}
}
