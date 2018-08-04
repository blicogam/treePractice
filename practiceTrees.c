
#include <stdio.h>
#include <stdlib.h>

typedef struct treeNode{
	int value;
	struct treeNode *left;
	struct treeNode *right;
}treeNode;

treeNode *createTreeNode(int data)
{
	treeNode *node = (treeNode*) malloc(sizeof(treeNode));
	node->value = data;
	node->left = NULL;
	node->right = NULL;
	return node;
}

void insertBinaryTree(treeNode **root, int value)
{
	if(*root == NULL)
	{
		*root = createTreeNode(value);
		return;		
	}

	if(value == (*root)->value)
	{
		printf("Duplicate: %d, not added\n", value);
		return;
	}

	// Insert right
	if(value > (*root)->value)
		insertBinaryTree( &((*root)->right), value);
	// Insert left
	else
		insertBinaryTree( &((*root)->left), value);

}

void inorderPrint(treeNode *root)
{
	if(root == NULL)
		return;
	inorderPrint(root->left);
	printf("%d\n", root->value);
	inorderPrint(root->right);
}
int main(int argc, int argv)
{
	treeNode *head = NULL;
	insertBinaryTree(&head, 36);
	insertBinaryTree(&head, 27);
	inorderPrint(head);
	return 0;
}