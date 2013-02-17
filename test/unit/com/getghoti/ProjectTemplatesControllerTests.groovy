package com.getghoti



import org.junit.*
import grails.test.mixin.*

@TestFor(ProjectTemplatesController)
@Mock(ProjectTemplates)
class ProjectTemplatesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/projectTemplates/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.projectTemplatesInstanceList.size() == 0
        assert model.projectTemplatesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.projectTemplatesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.projectTemplatesInstance != null
        assert view == '/projectTemplates/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/projectTemplates/show/1'
        assert controller.flash.message != null
        assert ProjectTemplates.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/projectTemplates/list'

        populateValidParams(params)
        def projectTemplates = new ProjectTemplates(params)

        assert projectTemplates.save() != null

        params.id = projectTemplates.id

        def model = controller.show()

        assert model.projectTemplatesInstance == projectTemplates
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/projectTemplates/list'

        populateValidParams(params)
        def projectTemplates = new ProjectTemplates(params)

        assert projectTemplates.save() != null

        params.id = projectTemplates.id

        def model = controller.edit()

        assert model.projectTemplatesInstance == projectTemplates
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/projectTemplates/list'

        response.reset()

        populateValidParams(params)
        def projectTemplates = new ProjectTemplates(params)

        assert projectTemplates.save() != null

        // test invalid parameters in update
        params.id = projectTemplates.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/projectTemplates/edit"
        assert model.projectTemplatesInstance != null

        projectTemplates.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/projectTemplates/show/$projectTemplates.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        projectTemplates.clearErrors()

        populateValidParams(params)
        params.id = projectTemplates.id
        params.version = -1
        controller.update()

        assert view == "/projectTemplates/edit"
        assert model.projectTemplatesInstance != null
        assert model.projectTemplatesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/projectTemplates/list'

        response.reset()

        populateValidParams(params)
        def projectTemplates = new ProjectTemplates(params)

        assert projectTemplates.save() != null
        assert ProjectTemplates.count() == 1

        params.id = projectTemplates.id

        controller.delete()

        assert ProjectTemplates.count() == 0
        assert ProjectTemplates.get(projectTemplates.id) == null
        assert response.redirectedUrl == '/projectTemplates/list'
    }
}
