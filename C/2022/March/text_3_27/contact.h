#pragma once
#include<stdio.h>
#include<string.h>
#include<assert.h>

#define MAX 1000
#define MAX_NAME 20
#define MAX_SEX 5
#define MAX_ADDER 30
#define MAX_TELE 15

//类型声明
enum Option
{
	EXIT,//0
	ADD,//1
	DELETE,//2
	SEARCH,//3
	MODIFY,//4
	SHOW,//5
	SORT//6
};

typedef struct PerInfo {
	int age;
	char name[MAX_NAME];
	char sex[MAX_SEX];
	char adder [MAX_ADDER];
	char tele[MAX_TELE];
}PerInfo;

typedef struct contact
{
	PerInfo data[MAX];
	int len;
}contact;

//函数声明
//初始化通讯录
void InitContact(contact* ps);
void AddContact(contact* ps);
void ShowContact(contact* ps);
void DeleteContact(contact *ps);
void SearchContact(contact *ps);
void ModifyContact(contact *ps);
void SortContact(contact* ps);