//package structural.composite;
//
//import java.util.function.Consumer;
//
//interface SomeNeurons extends Iterable<Neuron>{
//    default void connectTo(SomeNeurons other){
//        if(this == other) return;
//
//        for(Neuron from : this){
//            for(Neuron to : other){
//                from.out.add(to);
//                to.in.add(from);
//            }
//        }
//    }
//}
//
//// 뉴런 들은 다른 뉴런과 연결이 되어 있음!
//class Neuron implements SomeNeurons{
//    public ArrayList<Neuron> in, out;
////    public void connectTo(Neuron other){
////        out.add(other);
////        other.in.add(this);
////    }
//
//    @Override
//    public Iterator<Neuron> iterator() {
//        return Collections.singleton(this).iterator();
//    }
//
//    @Override
//    public void forEach(Consumer<? super Neuron> action) {
//        action.accept(this);
//    }
//
//    @Override
//    public Spliterator<Neuron> spliterator() {
//        return Collections.singleton(this).spliterator();
//    }
//}
//
///*
//위에서 주석처리된 사용 방식은 매우 적절하지 못한 연결 방식
//그래서 Neuron Layer를 사용하여 Uniform 한 방식으로 전체 Group object를 다룰 것
// */
//class NeuronLayer extends ArrayList<Neuron> implements SomeNeurons{
//
//}
//
//public class NeuralNetwork {
//    public static void main(String[] args){
//        Neuron neuron = new Neuron();
//        Neuron neuron2 = new Neuron();
//        NeuronLayer layer = new NeuronLayer();
//        NeuronLayer layer2 = new NeuronLayer();
//
//        // 다음과 같이 뉴런과 layer를 각각 다 이어주는 방식은 매우 비현실적
//        // N개의 뉴런이 있다면 2^N 이 되어버리는 복잡성.
////        neuron.connectTo(neuron2);
////        neuron.connectTo(layer);
////        layer.connectTo(neuron);
////        layer.connectTo(layer2);
//    }
//}
