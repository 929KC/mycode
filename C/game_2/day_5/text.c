#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include"game.h"
void menu()
{
	printf("***欢迎来到扫雷荣耀***\n");
	printf("****1.play 0.exit****\n");
	printf("*********************\n");
}

 void game()
{
	char mine[ROWS][COLS] = { 0 };//埋雷
	char show[ROWS][COLS] = { 0 };//扫雷
	//初始化棋盘
	InitBoard(mine,ROWS, COLS,'0');
	InitBoard(show, ROWS, COLS, '*');
	//打印棋盘
	
	
	/*DispalyBoard(show, ROW, COL);*/
	//布置雷
	SetMine(mine ,ROW ,COL);
	/*DispalyBoard(mine, ROW, COL);*/
	/*DispalyBoard(mine, ROW, COL);*/
	//扫雷
	DispalyBoard(show, ROW, COL);
	FindMine(mine, show, ROW, COL);
}

void text() {
	int input = 0;
	srand((unsigned int)time(NULL));
	do {
		menu();
		printf("请输入你的选择：>");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			//printf("扫雷\n");
			break;
		case 0:
			printf("退出游戏！");
			break;
		default:
			printf("你输入的有误，请重新输入！");
			break;
		}
	} while (input);

}

int main() {

	text();
	return 0;
}