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
		printf("ͨѶ¼�������޷����");
		return;
	}

		printf("��������Ҫxxx�Ļ�����Ϣ��\n");
		printf("������������");
		scanf("%s", ps->data[ps->len].name);
		printf("���������䣺");
		scanf("%d", &(ps->data[ps->len].age));
		printf("�������Ա�");
		scanf("%s", ps->data[ps->len].sex);
		printf("�������ֻ����룺");
		scanf("%s", ps->data[ps->len].tele);
		printf("������סַ��");
		scanf("%s", ps->data[ps->len].adder);
		ps->len++;
		printf("��ӳɹ���\n");
}

void ShowContact(contact* ps)
{
	assert(ps);
	printf("%-20s %-5s %-5s %-12s %-30s\n", "����", "����", "�Ա�", "�ֻ�����", "��ַ");
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
	printf("��������Ҫɾ������ϵ�˵����֣�");
	scanf("%s", name);
	int ret=isByName(ps, name);
	if (ps->len >= 0)
	{
		printf("ͨѶ¼Ϊ�գ��޷�ɾ��\n");
		return;
	}

	if (ret == -1)
	{
		printf("���޴���");
	}
	else 
	{
		for (int i = 0; i < ps->len - 1; i++)
		{
			ps->data[i] = ps->data[i + 1];
		}
		ps->len--;
		printf("ɾ���ɹ���\n");
	}
	
}

void SearchContact(contact* ps)
{
	assert(ps);
	char name[20] = { 0 };
	printf("��������Ҫ���ҵ���ϵ�˵����֣�");
	scanf("%s", name);
	int pos = isByName(ps, name);

	if (pos == -1)
	{
		printf("���޴���");
	}
	else
	{
		printf("%-20s %-5s %-5s %-12s %-30s\n", "����", "����", "�Ա�", "�ֻ�����", "��ַ");
		printf("%-20s %-5d %-5s %-12s %-30s\n", ps->data[pos].name, ps->data[pos].age
			, ps->data[pos].sex, ps->data[pos].tele, ps->data[pos].adder);
	}
}

void ModifyContact(contact* ps)
{
	assert(ps);
	char name[20] = { 0 };
	printf("��������Ҫ�޸ĵ���ϵ�˵����֣�");
	scanf("%s", name);
	int pos = isByName(ps, name);
	if (pos == -1)
	{
		printf("���޴���");
	}
	else
	{
		printf("������������");
		scanf("%s", ps->data[pos].name);
		printf("���������䣺");
		scanf("%d", &(ps->data[pos].age));
		printf("�������Ա�");
		scanf("%s", ps->data[pos].sex);
		printf("�������ֻ����룺");
		scanf("%s", ps->data[pos].tele);
		printf("������סַ��");
		scanf("%s", ps->data[pos].adder);
		printf("����޸ģ�\n");
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