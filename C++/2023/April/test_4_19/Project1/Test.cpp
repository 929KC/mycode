#include<iostream>
using namespace std;
int Add(int left, int right)
{
	return left + right;
}

double Add(double left, double right)
{
	return left + right;
}

int main() 
{
	
	cout << Add(12, 12) << endl;
	cout << Add(12.12, 12.12) << endl;

	return 0;
}