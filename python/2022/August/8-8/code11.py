import  xlrd

from code1 import total

xlsx = xlrd.open_workbook("E:/测试/test.xlsx")
table = xlsx.sheet_by_index(0)
nrows = table.nrows
total = 0
count = 0

for i in range(1,nrows):
    classId = table.cell_value(i,1)
    if classId == 100:
        total += table.cell_value(i,2)
        count+=1
print(f'平均数:{total/count}')