public enum Mark {
    EMPTY {
        public String toString(){
            return "";
        }
    },
    CROSS {
        public String toString(){
            return "X";
        }
    },
    NOUGHT {
        public String toString(){
            return "O";
        }
    };
    Mark(){}
}
