public class sbox {
public void sBox()
{
int part0 = 0;
int part1 = 0;
int part2 = 0;
int part3 = 0;
int final = 0;
int key0 = 0x8D33ABFB;
int key1 = 0xF2900FAE;
int result0 = 0;
int result1 = 0;
part0 = gen_qtable(INPUT,0);
part1 = gen_qtable(INPUT,1);
part2 = gen_qtable(INPUT,0);
part3 = gen_qtable(INPUT,1);
final = part3 | (part2<<8) | (part1<<16) | (part0<<24);
Result0 = final ^ key0;
Result1 = final ^ key1;
}
