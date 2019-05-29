package dagger.qualifier.demo;

import javax.inject.Named;

import dagger.Component;

@Component(modules = {CardModuleSloth.class})
interface QualifierComponent {

    @Named("tony")
    String namedString();

    @ScarlettString
    String scarlettString();

    String sloth();
}