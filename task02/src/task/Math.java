package task;

public class Math {
    
    private static float last=0.0f;

    public String calculate(String problem){
        String[] initial = problem.trim().split(" ",-1);
        Float result = 0f;
        Float operand_1;
        Float operand_2;
        
        if(initial[0].equals("$last")){
            operand_1 = last;
        } else{
            operand_1 = Float.parseFloat(initial[0]);
        }
        
        if(initial[2].equals("$last")){
            operand_2 = last;
        } else{
            operand_2 = Float.parseFloat(initial[2]);            
        }

        String operator = initial[1];
        switch(operator){
            case "+"->result = operand_1+operand_2;
            case "-"->result = operand_1-operand_2;
            case "*"->result = operand_1*operand_2;
            case "/"->result = operand_1/operand_2;          
        }

        last = result;                     
        String ans = result.toString();

        return ans;
    }    
}
