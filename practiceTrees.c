
// Need to add part to delete node with two children

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

int doesItExistsNode(treeNode *root, int value)
{
	if(root == NULL)
		return 0;
	if(root->value == value)
		return 1;
	if(root->value < value)
		return doesItExistsNode(root->right, value);
	else
		return doesItExistsNode(root->left, value);
}

void deleteBinaryTree(treeNode **root, int value)
{
	if(*root == NULL)
		return;
	if(doesItExistsNode == 0)
	{
		printf("Not found, can't delete: %d\n", value);
		return;
	}

	treeNode *temp = *root, *prev = *root;

	while(temp != NULL)
	{
		if(temp->value > value)
		{
			prev = temp;
			temp = temp->left;
		}
		else if(temp->value < value)
		{
			prev = temp;
			temp = temp->right;
		}
		else
			break;
	}

	if(temp == NULL)
	{
		printf("ERROR\n");
		return;
	}

	if(temp->left == NULL && temp->right == NULL)
	{
		if(prev->value > temp->value)
			prev->left = NULL;
		else
			prev->right = NULL;
		free(temp);
		return;
	}

	else if(temp->left == NULL)
	{
		if(prev->value > temp->value)
		{
			prev->left = temp->right;
			free(temp);
		}
		else
		{
			prev->right = temp->right;
			free(temp);
		}
	}

	else if(temp->right == NULL)
	{
		if(prev->value > temp->value)
		{
			prev->left = temp->left;
			free(temp);
		}
		else
		{
			prev->right = temp->left;
			free(temp);
		}
	}

	else
	{

	}
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
	insertBinaryTree(&head, 45);
	insertBinaryTree(&head, 15);
	inorderPrint(head);
	printf("%d\n", doesItExistsNode(head, 15));
	return 0;
}