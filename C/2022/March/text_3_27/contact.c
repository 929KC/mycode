#define _CRT_SECURE_NO_WARNINGS 1
#include "contact.h"
void InitContact(contact* ps)
{
	ps->len = 0;
	memset(ps->data,0,sizeof(ps->data));
}

void AddContact(contact* ps)
{
	if (ps->len == MAX)
	{
		printf("通讯录已满，无法添加");
		return;
	}

		printf("请输入您要xxx的基本信息：\n");
		printf("请输入姓名：");
		scanf("%s", ps->data[ps->len].name);
		printf("请输入年龄：");
		scanf("%d", &(ps->data[ps->len].age));
		printf("请输入性别：");
		scanf("%s", ps->data[ps->len].sex);
		printf("请输入手机号码：");
		scanf("%s", ps->data[ps->len].tele);
		printf("请输入住址：");
		scanf("%s", ps->data[ps->len].adder);
		ps->len++;
		printf("添加成功！\n");
}

void ShowContact(contact* ps)
{
	assert(ps);
	printf("%-20s %-5s %-5s %-12s %-30s\n", "姓名", "年龄", "性别", "手机号码", "地址");
	for (int i = 0; i < ps->len; i++)
	{
		printf("%-20s %-5d %-5s %-12s %-30s\n", ps->data[i].name, ps->data[i].age
			, ps->data[i].sex, ps->data[i].tele, ps->data[i].adder);
	}

}
int isByName(contact *ps,char  name[])
{
	for (int i = 0; i < ps->len; i++)
	{
		if (0 == strcmp(ps->data[i].name, name))
		{
			return 1;
		}
	}
	return -1;
}

void DeleteContact(contact *ps)
{
	assert(ps);
	char name[20] = { 0 };
	printf("请输入您要删除的联系人的名字：");
	scanf("%s", name);
	int ret=isByName(ps, name);
	if (ps->len >= 0)
	{
		printf("通讯录为空，无法删除\n");
		return;
	}

	if (ret == -1)
	{
		printf("查无此人");
	}
	else 
	{
		for (int i = 0; i < ps->len - 1; i++)
		{
			ps->data[i] = ps->data[i + 1];
		}
		ps->len--;
		printf("删除成功！\n");
	}
	
}

void SearchContact(contact* ps)
{
	assert(ps);
	char name[20] = { 0 };
	printf("请输入您要查找的联系人的名字：");
	scanf("%s", name);
	int pos = isByName(ps, name);

	if (pos == -1)
	{
		printf("查无此人");
	}
	else
	{
		printf("%-20s %-5s %-5s %-12s %-30s\n", "姓名", "年龄", "性别", "手机号码", "地址");
		printf("%-20s %-5d %-5s %-12s %-30s\n", ps->data[pos].name, ps->data[pos].age
			, ps->data[pos].sex, ps->data[pos].tele, ps->data[pos].adder);
	}
}

void ModifyContact(contact* ps)
{
	assert(ps);
	char name[20] = { 0 };
	printf("请输入您要修改的联系人的名字：");
	scanf("%s", name);
	int pos = isByName(ps, name);
	if (pos == -1)
	{
		printf("查无此人");
	}
	else
	{
		printf("请输入姓名：");
		scanf("%s", ps->data[pos].name);
		printf("请输入年龄：");
		scanf("%d", &(ps->data[pos].age));
		printf("请输入性别：");
		scanf("%s", ps->data[pos].sex);
		printf("请输入手机号码：");
		scanf("%s", ps->data[pos].tele);
		printf("请输入住址：");
		scanf("%s", ps->data[pos].adder);
		printf("添加修改！\n");
	}
}
int ComparyByName(const void* e1, const void* e2)
{
	return strcmp((const char*)e1, (const char*)e2);
}

void SortContact(contact* ps) 
{
	qsort(ps->data, ps->len, sizeof(PerInfo), ComparyByName);
}