package it.cnr.saks.sisma.testing;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TestInformation {
    private final ArrayList<MethodCall> methodCalls = new ArrayList<>();
    private final ArrayList<EndPoint> endPoints = new ArrayList<>();
    private final ArrayList<String> exceptions = new ArrayList<>();

    protected void addMethodCall(String methodName, String methodDescriptor, String className, String pathId, String programPoint) {
        for(MethodCall md : this.methodCalls) {
            if (md.getMethodDescriptor().equals(methodDescriptor) && md.getClassName().equals(className) && md.getPathId().equals(pathId)) {
                return;
            }
        }

        MethodCall md = new MethodCall(null, methodName, methodDescriptor, className, pathId, programPoint);
        this.methodCalls.add(md);
    }

    protected void addEndPoint(String type, String endPoint, String args, String pathId) {
        for(EndPoint ep : this.endPoints) {
            if(ep.getEndPoint().equals(endPoint) && ep.getPathId().equals(pathId)) {
                return;
            }
        }

        EndPoint ep = new EndPoint(type, endPoint, args, pathId);
        this.endPoints.add(ep);
    }

    protected void addException(String exception) {
        this.exceptions.add(exception);
    }

    public ArrayList<MethodCall> getMethodCalls() {
        return this.methodCalls;
    }

    public ArrayList<EndPoint> getEndPoints() {
        return this.endPoints;
    }

    public ArrayList<String> getExceptions() {
        return this.exceptions;
    }


    protected class EndPoint {
        private final String type;
        private final String endPoint;
        private final String args;
        private final String pathId;

        private EndPoint(String type, String endPoint, String args, String pathId) {
            this.type = type;
            this.endPoint = endPoint;
            this.args = args;
            this.pathId = pathId;
        }

        public String getType() {
            return type;
        }

        public String getEndPoint() {
            return endPoint;
        }

        public String getArgs() {
            return args;
        }

        public String getPathId() {
            return pathId;
        }

    }


    protected class MethodCall {
        private final String methodName;
        private final String methodDescriptor;
        private final String className;
        private final String pathId;
        private final String programPoint;


        public MethodCall(Method method, String methodName, String methodDescriptor, String className, String pathId, String programPoint) {
            this.methodName = methodName;
            this.methodDescriptor = methodDescriptor;
            this.className = className;
            this.pathId = pathId;
            this.programPoint = programPoint;
        }

        public String getClassName() {
            return className;
        }

        public String getMethodDescriptor() {
            return methodDescriptor;
        }

        public String getMethodName() {
            return methodName;
        }

        public String getPathId() {
            return pathId;
        }

        public String getProgramPoint() {
            return programPoint;
        }

    }
}