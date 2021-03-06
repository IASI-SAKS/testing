package it.cnr.saks.hyperion.symbolic;

import it.cnr.saks.hyperion.facts.InformationLogger;
import jbse.algo.exc.CannotManageStateException;
import jbse.bc.Signature;
import jbse.bc.exc.InvalidClassFileFactoryClassException;
import jbse.common.exc.ClasspathException;
import jbse.common.exc.InvalidInputException;
import jbse.common.exc.UnexpectedInternalException;
import jbse.dec.*;
import jbse.dec.exc.DecisionException;
import jbse.jvm.Engine;
import jbse.jvm.Runner;
import jbse.jvm.RunnerBuilder;
import jbse.jvm.exc.*;
import jbse.mem.State;
import jbse.mem.exc.ContradictionException;
import jbse.mem.exc.FrozenStateException;
import jbse.mem.exc.ThreadStackEmptyException;
import jbse.rewr.CalculatorRewriting;
import jbse.rewr.RewriterOperationOnSimplex;
import jbse.rules.ClassInitRulesRepo;
import jbse.rules.LICSRulesRepo;
import jbse.tree.StateTree;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static jbse.bc.Opcodes.*;

public final class Analyzer {
    private boolean trackMethods = false;

    private Engine engine;
    private final AnalizerParameters analizerParameters;

    private final InformationLogger informationLogger;

    public Analyzer(InformationLogger informationLogger) throws AnalyzerException {
        this.analizerParameters = new AnalizerParameters();
        this.analizerParameters.setActions(new ActionsRun());

        this.informationLogger = informationLogger;
        this.informationLogger.resetCounters();
    }

    public void setupStatic() {
        this.withUninterpreted("org/springframework/util/Assert", "(Z)V", "state")
            .withUninterpreted("org/springframework/util/Assert", "(ZLjava/lang/String;)V", "state")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)V", "isAssignable")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/Class;Ljava/lang/Class;)V", "isAssignable")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;)V", "isInstanceOf")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/Class;Ljava/lang/Object;)V", "isInstanceOf")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/util/Map;)V", "notEmpty")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/util/Map;Ljava/lang/String;)V", "notEmpty")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/util/Collection;)V", "notEmpty")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/util/Collection;Ljava/lang/String;)V", "notEmpty")
            .withUninterpreted("org/springframework/util/Assert", "([Ljava/lang/Object;)V", "noNullElements")
            .withUninterpreted("org/springframework/util/Assert", "([Ljava/lang/Object;Ljava/lang/String;)V", "noNullElements")
            .withUninterpreted("org/springframework/util/Assert", "([Ljava/lang/Object;)V", "notEmpty")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/String;Ljava/lang/String;)V", "doesNotContain")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "doesNotContain")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/String;)V", "hasText")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/String;Ljava/lang/String;)V", "hasText")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/String;)V", "hasLength")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/String;Ljava/lang/String;)V", "hasLength")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/Object;)V", "notNull")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/Object;Ljava/lang/String;)V", "notNull")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/Object;)V", "isNull")
            .withUninterpreted("org/springframework/util/Assert", "(Ljava/lang/Object;Ljava/lang/String;)V", "isNull")
            .withUninterpreted("org/springframework/util/Assert", "(ZLjava/lang/String;)V", "isTrue")
            .withUninterpreted("org/springframework/util/Assert", "(Z)V", "isTrue");

        this.withUninterpreted("org/junit/Assert", "([Z[Z)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "([B[B)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "([C[C)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "([D[DD)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "([F[FF)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "([I[I)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "([J[J)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "([Ljava/lang/Object;[Ljava/lang/Object;)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "([S[S)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;[Z[Z)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;[B[B)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;[C[C)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;[D[DD)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;[F[FF)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;[I[I)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;[J[J)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;[LObject;[Ljava/lang/Object;)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;[S[S)V", "assertArrayEquals")
            .withUninterpreted("org/junit/Assert", "(DD)V", "assertEquals")
            .withUninterpreted("org/junit/Assert", "(DDD)V", "assertEquals")
            .withUninterpreted("org/junit/Assert", "(FFF)V", "assertEquals")
            .withUninterpreted("org/junit/Assert", "(JJ)V", "assertEquals")
            .withUninterpreted("org/junit/Assert", "([Ljava/lang/Object;[Ljava/lang/Object;)V", "assertEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/Object;Ljava/lang/Object;)V", "assertEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;DD)V", "assertEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;DDD)V", "assertEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;FFF)V", "assertEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;JJ)V", "assertEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Object;)V", "assertEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "assertEquals")
            .withUninterpreted("org/junit/Assert", "(Z)V", "assertFalse")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;Z)V", "assertFalse")
            .withUninterpreted("org/junit/Assert", "(DDD)V", "assertNotEquals")
            .withUninterpreted("org/junit/Assert", "(FFF)V", "assertNotEquals")
            .withUninterpreted("org/junit/Assert", "(JJ)V", "assertNotEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/Object;Ljava/lang/Object;)V", "assertNotEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;DDD)V", "assertNotEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;FFF)V", "assertNotEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;JJ)V", "assertNotEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "assertNotEquals")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;Ljava/lang/Object;)V", "assertNotNull")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/Object;Ljava/lang/Object;)V", "assertNotSame")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "assertNotSame")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/Object;)V", "assertNull")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;Ljava/lang/Object;)V", "assertNull")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/Object;Ljava/lang/Object;)V", "assertSame")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "assertSame")
            .withUninterpreted("org/junit/Assert", "(Z)V", "assertTrue")
            .withUninterpreted("org/junit/Assert", "(Ljava/lang/String;Z)V", "assertTrue");
    }

    public class ActionsRun extends Runner.Actions {

        @Override
        public boolean atInitial() {
            Analyzer.this.trackMethods = true;
            return super.atInitial();
        }

        @Override
        public boolean atBranch(StateTree.BranchPoint bp) {
            if(Analyzer.this.trackMethods) {
                final State currentState = Analyzer.this.engine.getCurrentState();
            }

            return super.atBranch(bp);
        }

        @Override
        public boolean atPathEnd() {
            if(Analyzer.this.trackMethods) {
                final State currentState = Analyzer.this.engine.getCurrentState();
            }
            return super.atPathEnd();
        }

        @Override
        public boolean atBacktrackPre() {
            if(Analyzer.this.trackMethods) {
                final State currentState = Analyzer.this.engine.getCurrentState();
            }

            return super.atBacktrackPre();
        }

        @Override
        public boolean atBacktrackPost(StateTree.BranchPoint bp) {
            if(Analyzer.this.trackMethods) {
                final State currentState = Analyzer.this.engine.getCurrentState();
            }

            return super.atBacktrackPost(bp);
        }

        // If backtrack is successful, called after atBacktrackPost
        @Override
        public boolean atBacktrackFinally() {
            if(Analyzer.this.trackMethods) {
                final State currentState = Analyzer.this.engine.getCurrentState();
            }

            return super.atBacktrackFinally();
        }

        @Override
        public void atEnd() {
            if(Analyzer.this.trackMethods) {
                final State currentState = Analyzer.this.engine.getCurrentState();
            }
        }

        @Override
        public boolean atMethodPre() {
            if(Analyzer.this.trackMethods) {
                final State currentState = Analyzer.this.engine.getCurrentState();
                Analyzer.this.informationLogger.onMethodCall(currentState);
            }

            return super.atMethodPre();
        }

        @Override
        public boolean atStepPre() {
            if(Analyzer.this.trackMethods) {
                final State currentState = Analyzer.this.engine.getCurrentState();
                try {
                    byte opcode = currentState.getInstruction();
                    if(opcode == OP_IRETURN || opcode == OP_LRETURN || opcode == OP_FRETURN || opcode == OP_DRETURN || opcode == OP_ARETURN || opcode == OP_RETURN)
                        Analyzer.this.informationLogger.onMethodReturn();
                } catch (ThreadStackEmptyException | FrozenStateException e) {
                    e.printStackTrace();
                }
            }

            return super.atStepPre();
        }
    }

    public void run() throws AnalyzerException {
        final CalculatorRewriting calc = createCalculator();
        this.analizerParameters.setCalculator(calc);
        this.analizerParameters.setDecisionProcedure(createDecisionProcedure(calc));

        try {
            final RunnerBuilder rb = new RunnerBuilder();
            final Runner runner = rb.build(this.analizerParameters.getRunnerParameters());
            this.engine = rb.getEngine();
            runner.run();
            this.engine.close();
        } catch (ClasspathException | DecisionException | CannotManageStateException | EngineStuckException | CannotBacktrackException | NonexistingObservedVariablesException | ThreadStackEmptyException | ContradictionException | FailureException | UnexpectedInternalException | CannotBuildEngineException | InitializationException | InvalidClassFileFactoryClassException e) {
            System.err.println(e.getStackTrace());
            throw new AnalyzerException(e.getMessage());
        }
    }


    public Analyzer withUserClasspath(URL[] urlPaths) {
        ArrayList<String> paths = new ArrayList<>();
        for (URL urlPath : urlPaths) {
            paths.add(urlPath.getPath());
        }
        String[] pathsArray = new String[paths.size()];
        pathsArray = paths.toArray(pathsArray);
        this.analizerParameters.addUserClasspath(pathsArray);
        return this;
    }

    public Analyzer withJbseEntryPoint(Signature method) {
        this.analizerParameters.setMethodSignature(method);
        return this;
    }

    public Analyzer withDepthScope(int depthScope) {
        this.analizerParameters.setDepthScope(depthScope);
        return this;
    }

    public Analyzer withTimeout(long time) {
        this.analizerParameters.setTimeout(time, TimeUnit.MINUTES);
        return this;
    }

    public Analyzer withTestProgram(Signature testProgramSignature) {
        this.analizerParameters.setTestProgramSignature(testProgramSignature);
        return this;
    }


    private DecisionProcedureAlgorithms createDecisionProcedure(CalculatorRewriting calc) throws AnalyzerException {
        // initializes core
        DecisionProcedure core = new DecisionProcedureAlwSat(calc);

        // wraps cores with external numeric decision procedure
        try {

            // Setup external numeric decision procedure
            final String switchChar = System.getProperty("os.name").toLowerCase().contains("windows") ? "/" : "-";
            final ArrayList<String> z3CommandLine = new ArrayList<>();
            z3CommandLine.add("z3");
            z3CommandLine.add(switchChar + "smt2");
            z3CommandLine.add(switchChar + "in");
            z3CommandLine.add(switchChar + "t:10");
            core = new DecisionProcedureSMTLIB2_AUFNIRA(core, z3CommandLine);
            core = new DecisionProcedureLICS(core, new LICSRulesRepo());
            core = new DecisionProcedureClassInit(core, new ClassInitRulesRepo());

            // Setup guidance using JDI
            core = new DecisionProcedureGuidanceJDI(core, calc, this.analizerParameters);

            // sets the result
            return new DecisionProcedureAlgorithms(core);

        } catch (DecisionException | InvalidInputException e) {
            throw new AnalyzerException(e);
        }
    }

    private CalculatorRewriting createCalculator() {
        final CalculatorRewriting calc = new CalculatorRewriting();
        calc.addRewriter(new RewriterOperationOnSimplex()); //indispensable
        return calc;
    }

    public Analyzer withUninterpreted(String methodClassName, String methodDescriptor, String methodName) {
        this.analizerParameters.addUninterpreted(methodClassName, methodDescriptor, methodName);
        return this;
    }

}