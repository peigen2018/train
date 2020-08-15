import com.dbapp.analyse.stream.sqlparse.MySqlLexer;
import com.dbapp.analyse.stream.sqlparse.MySqlParser;
import com.dbapp.analyse.stream.sqlparse.MySqlParserBaseVisitor;
import com.dbapp.analyse.stream.sqlparse.MySqlParserVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

public class utils {
    public static void main(String[] args) {

        String sql = "SELECT CUST_NAME FROM CUSTOMERS WHERE CUST_NAME LIKE 'Kash%'";

        MySqlLexer lexer = new MySqlLexer(CharStreams.fromString(sql));
        MySqlParser parser = new MySqlParser(new CommonTokenStream(lexer));

        MySqlParser.TableNameContext tableNameContext = parser.tableName();


        MySqlParserBaseVisitor visitor = new MySqlParserBaseVisitor();
        Object o = visitor.visitAdministrationStatement(parser.administrationStatement());



    }
}
