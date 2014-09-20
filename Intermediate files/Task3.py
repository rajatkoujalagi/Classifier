f=open("Test1_Input_approach3.csv")
read=f.readlines()
w=open("approach3-test.csv","w")
for iterator in read:
    if(len(iterator.strip())>0):
        w=iterator.strip().split(',')
        for i in range(0,100):
            w.write("%s,%s,%s\n"%(w[i],w[i+100],w[i+200]))
w.close()
