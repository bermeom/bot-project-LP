package co.edu.javeriana.bot.ast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WhileLoop implements ASTNode {
	
	private ASTNode condition;
	private List<ASTNode>  body;
	
	public WhileLoop(ASTNode condition, List<ASTNode> body) {
		super();
		this.condition = condition;
		this.body = body;
	}

	@Override
	public Object execute(List<Map<String,Object>>  symbolTables, ProgramInfo programInfo) {
		while((boolean)this.condition.execute(symbolTables, null)){
			if(this.body!=null){
				symbolTables.add(new HashMap<String, Object>());
				for(ASTNode n: this.body){
					n.execute(symbolTables, programInfo);
				}
				symbolTables.remove(symbolTables.size()-1);
			}
		}
		return null;
	}

}