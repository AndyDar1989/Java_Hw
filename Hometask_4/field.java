if (field[i + 1][j+1] == 0) {
                i++;
                j++;
                field[i][j] +=1;
                quPath.add(field[i][j]);  
                   
                }
            if (field[i - 1][j-1] == 0) {
                i--;j--;
                field[i][j] +=1;
                quPath.add(field[i][j]); 
                    
                }
            if (field[i - 1][j+1] == 0) {
                i--;j++;
                field[i][j] +=1;
                quPath.add(field[i][j]); 
                    
                }
            if (field[i+1][j-1] == 0) {
                i++; j--;
                field[i][j] +=1;
                quPath.add(field[i][j]);   
            }