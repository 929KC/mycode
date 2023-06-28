#include<iostream>
using namespace std;

struct Demo
{
	int a = 90;
	int b = 90;
	int  Add(int left ,int right)
	{
		return left + right;
    }
};
class Person
{
public:
	int age = 19;
	string name = "叶秋寒";
	int  Print()
	{
		cout << "我是好学生" << endl;
		return 1;
	}
};
int main()
{

	Demo demo;
	Person person;
	int ret = person.Print();
	cout << demo.a << endl;
	cout << demo.b << endl;
	cout << demo.Add(12,12) << endl;
	cout << demo.Add(12, 12) << endl;
	cout << person.age << endl;
	cout << person.name << endl;
	cout << ret << endl;
	return 0;
}