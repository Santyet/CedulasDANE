public class ABB {

    private int count;

    private Node root;

    public ABB() {

    }

    public void insert(Node current) {

        if (root == null) {
            root = current;
        } else {
            insert(current, root);
        }
    }

    private void insert(Node node, Node current) {
        if (node.getCitizen().getId() < current.getCitizen().getId()) {
            //izauierda
            if (current.getLeft() != null) {
                insert(node, current.getLeft());
            } else {
                current.setLeft(node);
            }
        } else if (node.getCitizen().getId() > current.getCitizen().getId()) {
            //derecha
            if (current.getRight() != null) {
                insert(node, current.getRight());
            } else {
                current.setRight(node);
            }
        }

    }

    public Node search(int goal) {
        count = 0;
        return search(goal, root);
    }

    private Node search(int goal, Node current) {

        if (current == null) {
            return null;
        }

        if (current.getCitizen().getId() == goal) {
            return current;
        } else if (goal < current.getCitizen().getId()) {
            count++;
            return search(goal, current.getLeft());
        } else {
            count++;
            return search(goal, current.getRight());
        }
    }

    public Node delete(int goal) {

        return delete(goal, root);
    }

    private Node delete(int goal, Node current){
        if(current == null){
            return null;
        }
        if(current.getCitizen().getId() == goal){
            //1. Nodo Hoja
            if(current.getLeft() == null && current.getRight() == null){
                if(current == root){
                    root = null;
                }else{

                }
                return null;
            }
            //2. Nodo solo hijo izquierdo
            else if (current.getRight() == null){
                if(current == root){
                    root = current.getLeft();
                }
                return current.getLeft();
            }
            //3. Nodo solo hijo derecho
            else if(current.getLeft() == null){
                if(current == root){
                    root = current.getRight();
                }
                return current.getRight();
            }
            //4. Nodo con dos hijos
            else{
                Node min = getMin(current.getRight());
                //Transferencia de valores, NUNCA de conexiones
                current.getCitizen().setId(min.getCitizen().getId());
                current.getCitizen().setName(min.getCitizen().getName());
                current.getCitizen().setBirthday(min.getCitizen().getBirthday());
                current.getCitizen().setCity(min.getCitizen().getCity());

                //Hacer eliminación a partir de la derecha
                Node subarbolDER = delete(min.getCitizen().getId(), current.getRight());
                current.setRight( subarbolDER );
                return current;
            }


        }else if(goal < current.getCitizen().getId()){
            Node subArbolIzquierdo = delete(goal, current.getLeft());
            current.setLeft(subArbolIzquierdo);
            return current;
        }else{
            Node subArbolDerecho = delete(goal, current.getRight());
            current.setRight(subArbolDerecho);
            return current;
        }
    }

    public Node getMin (Node current){
        if (current.getLeft() == null){
            return current;
        }

        return getMin(current.getLeft());
    }

    public int getCount() {
        return count;
    }
}
