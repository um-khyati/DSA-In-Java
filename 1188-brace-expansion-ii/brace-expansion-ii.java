class Solution {
    String[] data;
    int size;
    int mask;
    int count;
    char[] expression;
    int elength;
    char[] result;

    void init(String expression) {
        size = 1 << 10;
        data = new String[size];
        mask = size - 1;
        count = 0;
        this.expression = expression.toCharArray();
        elength = this.expression.length;
        result = new char[elength];
    }
    
    int hash(String s) {
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            result = result * 37 + s.charAt(i);
        }
        return result & mask;
    }
    
    void add(String s) {
        int code = hash(s);
        String at = data[code];
        while (at != null && !at.equals(s)) {
            code = (code + 1) & mask;
            at = data[code];
        }
        if (at == null) {
            data[code] = s;
            ++count;
        }
    }

    void parseChoice(int epos, int rpos) {
        parse(epos, rpos);
        int depth = 1;
        for ( ; depth != 0; ++epos) {
            switch (expression[epos]) {
                case '{': ++depth; break;
                case '}': --depth; break;
                case ',': 
                    if (depth == 1) {
                        parse(epos + 1, rpos);
                    }
                    break;
            }
        }
    }

    void parse(int epos, int rpos) {
        boolean skip = false;
        int depth = 0;
        for (; epos != elength; ++epos) {
            char c = expression[epos];
            if (skip) {
                switch (c) {
                    case '{': ++depth; break;
                    case '}': 
                        if (depth == 0) {
                            skip = false;
                        } else {
                            --depth;
                        }
                        break;
                }
                continue;
            }
            switch (c) {
                case ',':
                    skip = true;
                    depth = 0;
                    break;
                case '{':
                    parseChoice(epos + 1, rpos);
                    return;
                case '}':
                    skip = false;
                    break;
                default:
                    result[rpos++] = c;
            }
        }
        add(new String(result, 0, rpos));
    }

    void quicksort(String[] arr, int l, int r) {
        String pivot = arr[l + ((r - l) >> 1)];
        int i = l, j = r;
        while (i <= j) {
            while (arr[i].compareTo(pivot) < 0) ++i;
            while (arr[j].compareTo(pivot) > 0) --j;
            if (i <= j) {
                String tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                ++i;
                --j;
            }
        }
        if (l < j) quicksort(arr, l, j);
        if (i < r) quicksort(arr, i, r);
    }
    
    public List<String> braceExpansionII(String expression) {
        init(expression);
        parse(0, 0);
        String[] result = new String[count];
        int resultCount = 0;
        for (int code = 0; code < size; ++code) {
            String value = data[code];
            if (value != null) {
                result[resultCount++] = value;
            }
        }
        quicksort(result, 0, count - 1);
        return Arrays.asList(result);
    }
}