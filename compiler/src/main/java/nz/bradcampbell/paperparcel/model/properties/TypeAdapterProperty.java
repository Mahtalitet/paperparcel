package nz.bradcampbell.paperparcel.model.properties;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import nz.bradcampbell.paperparcel.model.Adapter;
import nz.bradcampbell.paperparcel.model.Property;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class TypeAdapterProperty extends Property {
  private final Adapter typeAdapter;

  public TypeAdapterProperty(Adapter typeAdapter, boolean isNullable, TypeName typeName, boolean isInterface,
                             String name, @Nullable String accessorMethodName) {
    super(isNullable, typeName, isInterface, name, accessorMethodName);
    this.typeAdapter = typeAdapter;
  }

  @Override
  protected CodeBlock readFromParcelInner(CodeBlock.Builder block, ParameterSpec in, @Nullable FieldSpec classLoader,
                                          Map<ClassName, CodeBlock> typeAdaptersMap, Set<String> scopedVariableNames) {
    return CodeBlock.of("$L.readFromParcel($N)", typeAdaptersMap.get(typeAdapter.getClassName()), in);
  }

  @Override
  protected void writeToParcelInner(
      CodeBlock.Builder block, ParameterSpec dest, ParameterSpec flags, CodeBlock sourceLiteral,
      Map<ClassName, CodeBlock> typeAdaptersMap, Set<String> scopedVariableNames) {
    block.addStatement("$L.writeToParcel($L, $N, $N)", typeAdaptersMap.get(typeAdapter.getClassName()), sourceLiteral,
                       dest, flags);
  }

  @Override public Set<Adapter> requiredTypeAdapters() {
    return Collections.singleton(typeAdapter);
  }
}
