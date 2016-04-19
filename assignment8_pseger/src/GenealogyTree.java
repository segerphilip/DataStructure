import javafoundations.*;
import javafoundations.exceptions.*;

import java.util.Iterator;

public class GenealogyTree<T> implements AncestryTree<T>, Iterable<T> {
    private T[] tree;

    // Set the size of the array to 15, mainly for testing
    private final int SIZE = 15;

    // Constructor that instantiates class with a root
    public GenealogyTree(T root) {
        tree = (T[]) new Object[SIZE];
        tree[0] = root;
    }

    //  Returns the element stored in the root (aka CoTU) of the tree.
    public T getCoTU() {
        return tree[0];
    }

    //  Returns the member that is the offspring of target.
    //  Returns null as the offspring of the root.
    public T getOffspring(T target) {
        if (target == tree[0]) {
            return null;
        }

        int tarIndex = (getIndex(target) - 1) / 2;
        try {
            return tree[tarIndex];
        }
        catch (ElementNotFoundException exception) {
            System.out.println("The parent does not exist");
            return null;
        }
    }

    //  Returns the member that is the left child of target.
    //  Returns null if the left child does not exist.
    public T getPater(T target) {
        int index = getIndex(target);
        if (index * 2 + 1 >= SIZE) {
            return null;
        } else if (tree[index * 2 + 1] == null) {
            return null;
        } else {
            return tree[index * 2 + 1];
        }
    }


    //  Sets the left child of the tree target to lchild.
    //  It throws an exception if target is not already in the tree
    public void setPater(T target, T lchild) throws ElementNotFoundException {
        int index = getIndex(target);
        if (index == -1) {
            throw new ElementNotFoundException("setPater: target not found");
        }
        if (index * 2 + 1 >= SIZE) {
            System.out.println("out of bound");
            return;
        } else {
            tree[index * 2 + 1] = lchild;
        }
    }

    //  Returns the element that is the right child of target.
    //  Returns null if the right child does not exist
    public T getMater(T target) {
        int index = getIndex(target);
        if (index * 2 + 2 >= SIZE) {
            return null;
        } else if (tree[index * 2 + 2] == null) {
            return null;
        } else {
            return tree[index * 2 + 2];
        }
    }

    //  Sets the right child of target to rchild.
    //  It throws an exception if target is not already in the tree
    public void setMater(T target, T rchild) throws ElementNotFoundException {
        int index = getIndex(target);
        if (index == -1) {
            throw new ElementNotFoundException("setMater: target not found");
        }
        if (index * 2 + 2 >= SIZE) {
            System.out.println("out of bound");
            return;
        } else {
            tree[index * 2 + 2] = rchild;
        }
    }

    //  Returns true if the tree contains an element that
    //  matches the specified target element and false otherwise.
    public boolean appears(T target) {
        int index = getIndex(target);
        return index != -1;
    }

    // Returns true if the two members share a grandchild,
    // and false if they are not or if a shared grandchild does not exist
    // Two grandparents that share a grandchild are "inLaws"
    public boolean inLaws(T gp1, T gp2) {
        T temp1Target = getOffspring(gp1);
        T gpTarget = getOffspring(temp1Target);

        T temp2Target = getOffspring(gp2);
        T gmTarget = getOffspring(temp2Target);

        if (temp1Target.equals(temp2Target)) {
            return false;
        }
        if (gpTarget.equals(gmTarget)) {
            return true;
        }
        return false;
    }

    //  Returns the number of members in this ancestral tree.
    public int size() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (tree[i] != null) {
                count++;
            }
        }
        return count;
    }

    // Helper function used to return index of specific values.
    private int getIndex(T target) {
        for (int i = 0; i < SIZE; i++) {
            if (tree[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //  Returns the string representation of the binary tree,
    // one line per level.
    public String toString() {
        String result = "";
        result += "My Genealogy contains " + size() + " members:\n";

        for (int i = 0; i < SIZE; i++) {
            // i below is used to check for exponentiation, and create newlines for readability
            if (((i+1) & -(i+1)) == (i+1)) {
                result += "\n";
            }

            result += tree[i] + " ";
        }

        return result;
    }

    //  Returns an iterator that contains a level-order traversal
    // on the ancestral tree.
    public Iterator<T> byGenerations() {
        ArrayIterator<T> iter = new ArrayIterator<T>();

        for (int i = 0; i < SIZE; i++) {
            iter.add(tree[i]);
        }

        return iter;
    }

    // Iterator method that can be called, returns the byGenerations
    // iterator implementation.
    public Iterator<T> iterator() {
        return byGenerations();
    }
}
