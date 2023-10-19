
def fac(n):
    temp = 0
    if n==0 or n==1:
        return n
    temp = fac(n-1)+fac(n-2)
    return  temp
print(fac(7))
