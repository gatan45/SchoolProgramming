#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXCHAR 10

void* mymalloc(int size) {
  void* ptr = malloc(size);
  fprintf(stderr,"malloc: %p\n",ptr);
  return ptr;
}

void myfree(void* ptr) {
  fprintf(stderr,"free: %p\n",ptr);
  free(ptr);
}

char *concatenate(char *a, char *b)
{
  int i = 0;
  int lengthA = strlen(a); 
  int lengthB = strlen(b);
  int stringLength = lengthA + lengthB;
  char * c = (char *)mymalloc(sizeof(char) * stringLength + 1);
  for(i = 0; i < lengthA; i++){
    c[i] = a[i];
  }
  for(i = 0; i < lengthB; i++){
    c[lengthA + i] = b[i];
  }
  c[stringLength] = '\0';
  return c;
}

int main(int argc, char **argv)
{
    if (argc != 4) {
	printf("Usage: hw1_leaky <count> <firstword> <secondword> \n");
	exit(1);
    }
    
    char *middle = "cruel";
    char number[MAXCHAR];
    int i = 0;

    for(i = 0;i < atoi(argv[1]); i++)
    {
	sprintf(number,"%d", i);
	
	//begin leaky
	char *cat = concatenate(argv[2], number);
	char *cat1 = concatenate(number, argv[3]);
	char *cat2 = concatenate(middle, cat1);
	char *line = concatenate(cat, cat2);
	myfree(cat);
	myfree(cat1);
	myfree(cat2);

	if(i > 0) //should not free statically allocated "cruel" string
	  free(middle);
	//end leaky
	printf("%s \n",line);
	middle = line;
    }

    myfree(middle);

}
