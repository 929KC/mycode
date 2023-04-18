#include<iostream>
using namespace std;
namespace kc 
{
	int a = 99;
	int b = 520;
	void test(int a, int b) {
		cout << a << endl;
		cout << b << endl;
	}
	struct Node {
		struct Node* next;
		int val;
	};
}

int main()
{
	cout << kc::a << kc::b << endl;
	kc::test(99, 99);
	cout << kc::Node val << endl;
	return 0;
}