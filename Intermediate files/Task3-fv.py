f=open("cluster32-test-data.csv")
read=f.readlines()
w=open("cluster32-test-data-fv.csv","w")
X=[[0]*32 for i in range(0,len(read)/100)]
ctr=0
for iterator in read:
    if(len(iterator.strip())>0):
        w=iterator.strip().split(',')
        X[ctr/100][int(w[0].split('_')[-1])]+=1
        ctr+=1

for i in X:
    line=""
    for j in i:
        line+="%d,"%j
    w.write("%s\n"%line[:-1])
w.close()
