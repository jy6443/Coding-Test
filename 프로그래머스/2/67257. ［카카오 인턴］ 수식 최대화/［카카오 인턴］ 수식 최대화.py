def cal(a,b,op):
    if op == '+':
        return a+b
    if op == '-':
        return a-b
    if op == '*':
        return a*b
import copy
def solution(expression):
    answer = []
    operator = []
    for p in expression:
        if not p.isdigit():
            operator.append(p)
    
    for c in ['+','-','*']:
        expression = expression.replace(c,' ')
        
    num = list(map(int,expression.split(' ')))
     
    order = [['+','-','*'],['+','*','-'],['-','+','*'],['-','*','+'],['*','+','-'],['*','-','+']] # 연산자 순서
    
    
    
    for arr in order:
        operand = copy.deepcopy(num)
        symbol = copy.deepcopy(operator)
        for sym in arr:
            while sym in symbol:
                i = symbol.index(sym)
                v = cal(operand[i],operand[i+1],sym)
                operand[i] = v
                operand.pop(i+1)
                symbol.pop(i)
        
        answer.append(abs(operand[0]))
        
    
    return max(answer)