/*
 * SonarQube
 * Copyright (C) 2009-2020 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.server.platform.db.migration.version.v84;

import org.sonar.server.platform.db.migration.step.MigrationStepRegistry;
import org.sonar.server.platform.db.migration.version.DbVersion;
import org.sonar.server.platform.db.migration.version.v84.activeruleparameters.AddPrimaryKeyOnUuidColumnOfActiveRuleParametersTable;
import org.sonar.server.platform.db.migration.version.v84.activeruleparameters.AddUuidColumnToActiveRuleParametersTable;
import org.sonar.server.platform.db.migration.version.v84.activeruleparameters.DropIdColumnOfActiveRuleParametersTable;
import org.sonar.server.platform.db.migration.version.v84.activeruleparameters.DropPrimaryKeyOnIdColumnOfActiveRuleParametersTable;
import org.sonar.server.platform.db.migration.version.v84.activeruleparameters.MakeActiveRuleParametersUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.activeruleparameters.PopulateActiveRuleParametersUuid;
import org.sonar.server.platform.db.migration.version.v84.activerules.AddActiveRuleUuidColumnToActiveRuleParameters;
import org.sonar.server.platform.db.migration.version.v84.activerules.AddIndexOnActiveRuleUuidOfActiveRuleParametersTable;
import org.sonar.server.platform.db.migration.version.v84.activerules.AddPrimaryKeyOnUuidColumnOfActiveRulesTable;
import org.sonar.server.platform.db.migration.version.v84.activerules.AddUuidColumnToActiveRulesTable;
import org.sonar.server.platform.db.migration.version.v84.activerules.DropActiveRuleIdColumnOfActiveRuleParametersTable;
import org.sonar.server.platform.db.migration.version.v84.activerules.DropIdColumnOfActiveRulesTable;
import org.sonar.server.platform.db.migration.version.v84.activerules.DropIndexOnActiveRuleIdOfActiveRuleParametersTable;
import org.sonar.server.platform.db.migration.version.v84.activerules.DropPrimaryKeyOnIdColumnOfActiveRulesTable;
import org.sonar.server.platform.db.migration.version.v84.activerules.MakeActiveRuleParametersActiveRuleUuidNotNullable;
import org.sonar.server.platform.db.migration.version.v84.activerules.MakeActiveRulesUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.activerules.PopulateActiveRuleParametersActiveRuleUuid;
import org.sonar.server.platform.db.migration.version.v84.activerules.PopulateActiveRulesUuid;
import org.sonar.server.platform.db.migration.version.v84.ceactivity.AddPrimaryKeyOnUuidColumnOfCeActivityTable;
import org.sonar.server.platform.db.migration.version.v84.ceactivity.DropIdColumnOfCeActivityTable;
import org.sonar.server.platform.db.migration.version.v84.ceactivity.DropPrimaryKeyOnIdColumnOfCeActivityTable;
import org.sonar.server.platform.db.migration.version.v84.cequeue.AddPrimaryKeyOnUuidColumnOfCeQueueTable;
import org.sonar.server.platform.db.migration.version.v84.cequeue.DropIdColumnOfCeQueueTable;
import org.sonar.server.platform.db.migration.version.v84.cequeue.DropPrimaryKeyOnIdColumnOfCeQueueTable;
import org.sonar.server.platform.db.migration.version.v84.cequeue.DropUniqueIndexOnUuidColumnOfCeQueueTable;
import org.sonar.server.platform.db.migration.version.v84.duplicationsindex.AddPrimaryKeyOnUuidColumnOfDuplicationsIndexTable;
import org.sonar.server.platform.db.migration.version.v84.duplicationsindex.AddUuidToDuplicationsIndexTable;
import org.sonar.server.platform.db.migration.version.v84.duplicationsindex.DropIdColumnOfDuplicationsIndexTable;
import org.sonar.server.platform.db.migration.version.v84.duplicationsindex.DropPrimaryKeyOnIdColumnOfDuplicationsIndexTable;
import org.sonar.server.platform.db.migration.version.v84.duplicationsindex.MakeDuplicationsIndexUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.duplicationsindex.PopulateDuplicationsIndexUuid;
import org.sonar.server.platform.db.migration.version.v84.events.AddPrimaryKeyOnUuidColumnOfEventsTable;
import org.sonar.server.platform.db.migration.version.v84.events.DropIdColumnOfEventsTable;
import org.sonar.server.platform.db.migration.version.v84.events.DropPrimaryKeyOnIdColumnOfEventsTable;
import org.sonar.server.platform.db.migration.version.v84.filesources.AddPrimaryKeyOnUuidColumnOfFileSourcesTable;
import org.sonar.server.platform.db.migration.version.v84.filesources.AddUuidColumnToFileSourcesTable;
import org.sonar.server.platform.db.migration.version.v84.filesources.DropIdColumnOfFileSourcesTable;
import org.sonar.server.platform.db.migration.version.v84.filesources.DropPrimaryKeyOnIdColumnOfFileSourcesTable;
import org.sonar.server.platform.db.migration.version.v84.filesources.MakeFileSourcesUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.filesources.PopulateFileSourcesUuid;
import org.sonar.server.platform.db.migration.version.v84.grouproles.AddPrimaryKeyOnUuidColumnOfGroupRolesTable;
import org.sonar.server.platform.db.migration.version.v84.grouproles.AddUuidColumnToGroupRolesTable;
import org.sonar.server.platform.db.migration.version.v84.grouproles.DropIdColumnOfGroupRolesTable;
import org.sonar.server.platform.db.migration.version.v84.grouproles.DropPrimaryKeyOnIdColumnOfGroupRolesTable;
import org.sonar.server.platform.db.migration.version.v84.grouproles.MakeGroupRolesUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.grouproles.PopulateGroupRolesUuid;
import org.sonar.server.platform.db.migration.version.v84.groups.AddPrimaryKeyOnUuidColumnOfGroupsTable;
import org.sonar.server.platform.db.migration.version.v84.groups.AddUuidColumnToGroupsTable;
import org.sonar.server.platform.db.migration.version.v84.groups.DropIdColumnOfGroupsTable;
import org.sonar.server.platform.db.migration.version.v84.groups.DropPrimaryKeyOnIdColumnOfGroupsTable;
import org.sonar.server.platform.db.migration.version.v84.groups.MakeGroupsUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.groups.PopulateGroupsUuid;
import org.sonar.server.platform.db.migration.version.v84.groups.grouproles.AddGroupUuidColumnToGroupRoles;
import org.sonar.server.platform.db.migration.version.v84.groups.grouproles.AddIndexOnGroupUuidOfGroupRolesTable;
import org.sonar.server.platform.db.migration.version.v84.groups.grouproles.DropGroupIdColumnOfGroupRolesTable;
import org.sonar.server.platform.db.migration.version.v84.groups.grouproles.DropIndexOnGroupIdOfGroupRolesTable;
import org.sonar.server.platform.db.migration.version.v84.groups.grouproles.PopulateGroupRolesGroupUuid;
import org.sonar.server.platform.db.migration.version.v84.groups.groupsusers.AddGroupUuidColumnToGroupsUsers;
import org.sonar.server.platform.db.migration.version.v84.groups.groupsusers.AddIndexOnGroupUuidOfGroupsUsersTable;
import org.sonar.server.platform.db.migration.version.v84.groups.groupsusers.DropGroupIdColumnOfGroupsUsersTable;
import org.sonar.server.platform.db.migration.version.v84.groups.groupsusers.DropIndexOnGroupIdOfGroupsUsersTable;
import org.sonar.server.platform.db.migration.version.v84.groups.groupsusers.MakeGroupsUsersGroupUuidNotNullable;
import org.sonar.server.platform.db.migration.version.v84.groups.groupsusers.PopulateGroupsUsersGroupUuid;
import org.sonar.server.platform.db.migration.version.v84.groups.organizations.AddDefaultGroupUuidColumnToOrganizations;
import org.sonar.server.platform.db.migration.version.v84.groups.organizations.DropDefaultGroupIdColumnOfOrganizationsTable;
import org.sonar.server.platform.db.migration.version.v84.groups.organizations.PopulateOrganizationsDefaultGroupUuid;
import org.sonar.server.platform.db.migration.version.v84.groups.permtemplatesgroups.AddGroupUuidColumnToPermTemplatesGroups;
import org.sonar.server.platform.db.migration.version.v84.groups.permtemplatesgroups.DropGroupIdColumnOfPermTemplatesGroupsTable;
import org.sonar.server.platform.db.migration.version.v84.groups.permtemplatesgroups.PopulatePermTemplatesGroupsGroupUuid;
import org.sonar.server.platform.db.migration.version.v84.groups.qprofileeditgroups.AddGroupUuidColumnToQProfileEditGroups;
import org.sonar.server.platform.db.migration.version.v84.groups.qprofileeditgroups.AddIndexOnGroupUuidOfQProfileEditGroupsTable;
import org.sonar.server.platform.db.migration.version.v84.groups.qprofileeditgroups.DropGroupIdColumnOfQProfileEditGroupsTable;
import org.sonar.server.platform.db.migration.version.v84.groups.qprofileeditgroups.DropIndexOnGroupIdOfQProfileEditGroupsTable;
import org.sonar.server.platform.db.migration.version.v84.groups.qprofileeditgroups.MakeQProfileEditGroupsGroupUuidNotNullable;
import org.sonar.server.platform.db.migration.version.v84.groups.qprofileeditgroups.PopulateQProfileEditGroupsGroupUuid;
import org.sonar.server.platform.db.migration.version.v84.issuechanges.AddPrimaryKeyOnUuidColumnOfIssueChangesTable;
import org.sonar.server.platform.db.migration.version.v84.issuechanges.AddUuidColumnToIssueChangesTable;
import org.sonar.server.platform.db.migration.version.v84.issuechanges.DropIdColumnOfIssueChangesTable;
import org.sonar.server.platform.db.migration.version.v84.issuechanges.DropPrimaryKeyOnIdColumnOfIssueChangesTable;
import org.sonar.server.platform.db.migration.version.v84.issuechanges.MakeIssueChangesUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.issuechanges.PopulateIssueChangesUuid;
import org.sonar.server.platform.db.migration.version.v84.issues.AddPrimaryKeyOnKeeColumnOfIssuesTable;
import org.sonar.server.platform.db.migration.version.v84.issues.DropIdColumnOfIssuesTable;
import org.sonar.server.platform.db.migration.version.v84.issues.DropPrimaryKeyOnIdColumnOfIssuesTable;
import org.sonar.server.platform.db.migration.version.v84.manualmeasures.AddPrimaryKeyOnUuidColumnOfManualMeasuresTable;
import org.sonar.server.platform.db.migration.version.v84.manualmeasures.AddUuidColumnToManualMeasures;
import org.sonar.server.platform.db.migration.version.v84.manualmeasures.DropIdColumnOfManualMeasuresTable;
import org.sonar.server.platform.db.migration.version.v84.manualmeasures.DropPrimaryKeyOnIdColumnOfManualMeasuresTable;
import org.sonar.server.platform.db.migration.version.v84.manualmeasures.MakeManualMeasuresUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.manualmeasures.PopulateManualMeasureUuid;
import org.sonar.server.platform.db.migration.version.v84.metrics.AddPrimaryKeyOnUuidColumnOfMetricsTable;
import org.sonar.server.platform.db.migration.version.v84.metrics.AddUuidColumnToMetricsTable;
import org.sonar.server.platform.db.migration.version.v84.metrics.DropIdColumnOfMetricsTable;
import org.sonar.server.platform.db.migration.version.v84.metrics.DropPrimaryKeyOnIdColumnOfMetricsTable;
import org.sonar.server.platform.db.migration.version.v84.metrics.MakeMetricsUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.metrics.PopulateMetricsUuid;
import org.sonar.server.platform.db.migration.version.v84.metrics.livemeasures.AddIndexOnMetricUuidOfLiveMeasuresTable;
import org.sonar.server.platform.db.migration.version.v84.metrics.livemeasures.AddMetricUuidColumnToLiveMeasures;
import org.sonar.server.platform.db.migration.version.v84.metrics.livemeasures.DropIndexOnMetricIdOfLiveMeasuresTable;
import org.sonar.server.platform.db.migration.version.v84.metrics.livemeasures.DropMetricIdColumnOfLiveMeasuresTable;
import org.sonar.server.platform.db.migration.version.v84.metrics.livemeasures.MakeLiveMeasuresMetricUuidNotNullable;
import org.sonar.server.platform.db.migration.version.v84.metrics.livemeasures.PopulateLiveMeasuresMetricUuid;
import org.sonar.server.platform.db.migration.version.v84.metrics.manualmeasures.AddMetricUuidColumnToManualMeasures;
import org.sonar.server.platform.db.migration.version.v84.metrics.manualmeasures.DropMetricIdColumnOfManualMeasuresTable;
import org.sonar.server.platform.db.migration.version.v84.metrics.manualmeasures.MakeManualMeasuresMetricUuidNotNullable;
import org.sonar.server.platform.db.migration.version.v84.metrics.manualmeasures.PopulateManualMeasuresMetricUuid;
import org.sonar.server.platform.db.migration.version.v84.metrics.projectmeasures.AddIndexOnMetricUuidOfProjectMeasuresTable;
import org.sonar.server.platform.db.migration.version.v84.metrics.projectmeasures.AddMetricUuidColumnToProjectMeasures;
import org.sonar.server.platform.db.migration.version.v84.metrics.projectmeasures.DropIndexOnMetricIdOfProjectMeasuresTable;
import org.sonar.server.platform.db.migration.version.v84.metrics.projectmeasures.DropMetricIdColumnOfProjectMeasuresTable;
import org.sonar.server.platform.db.migration.version.v84.metrics.projectmeasures.MakeProjectMeasuresMetricUuidNotNullable;
import org.sonar.server.platform.db.migration.version.v84.metrics.projectmeasures.PopulateProjectMeasuresMetricUuid;
import org.sonar.server.platform.db.migration.version.v84.metrics.qualitygateconditions.AddMetricUuidColumnToQualityGateConditions;
import org.sonar.server.platform.db.migration.version.v84.metrics.qualitygateconditions.DropMetricIdColumnOfQualityGateConditionsTable;
import org.sonar.server.platform.db.migration.version.v84.metrics.qualitygateconditions.MakeQualityGateConditionsMetricUuidNotNullable;
import org.sonar.server.platform.db.migration.version.v84.metrics.qualitygateconditions.PopulateQualityGateConditionsMetricUuid;
import org.sonar.server.platform.db.migration.version.v84.notifications.AddPrimaryKeyOnUuidColumnOfNotificationTable;
import org.sonar.server.platform.db.migration.version.v84.notifications.AddUuidAndCreatedAtColumnsToNotification;
import org.sonar.server.platform.db.migration.version.v84.notifications.DropIdColumnOfNotificationTable;
import org.sonar.server.platform.db.migration.version.v84.notifications.DropPrimaryKeyOnIdColumnOfNotificationTable;
import org.sonar.server.platform.db.migration.version.v84.notifications.MakeNotificationUuidAndCreatedAtColumnsNotNullable;
import org.sonar.server.platform.db.migration.version.v84.notifications.PopulateNotificationUuidAndCreatedAt;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.AddPrimaryKeyOnUuidColumnOfPermissionTemplatesTable;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.AddUuidColumnToPermissionTemplates;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.DropIdColumnOfPermissionTemplatesTable;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.DropKeeColumnOfPermissionTemplatesTable;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.DropPrimaryKeyOnIdColumnOfPermissionTemplatesTable;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.MakePermissionTemplateUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.PopulatePermissionTemplatesUuid;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtemplatesgroups.AddTemplateUuidColumnToPermTemplatesGroups;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtemplatesgroups.DropTemplateIdColumnOfPermTemplatesGroupsTable;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtemplatesgroups.MakePermTemplatesGroupsTemplateUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtemplatesgroups.PopulatePermTemplatesGroupsTemplateUuidColumn;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtemplatesusers.AddTemplateUuidColumnToPermTemplatesUsers;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtemplatesusers.DropTemplateIdColumnOfPermTemplatesUsersTable;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtemplatesusers.MakePermTemplatesUsersTemplateUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtemplatesusers.PopulatePermTemplatesUsersTemplateUuidColumn;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtplcharacteristics.AddTemplateUuidColumnToPermTplCharacteristics;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtplcharacteristics.AddUniqueIndexOnTemplateUuidAndPermissionKeyColumnsOfPermTplCharacteristicsTable;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtplcharacteristics.DropTemplateIdColumnOfPermTplCharacteristicsTable;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtplcharacteristics.DropUniqueIndexOnTemplateIdAndPermissionKeyColumnsOfPermTplCharacteristicsTable;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtplcharacteristics.MakePermTplCharacteristicsTemplateUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.permissiontemplates.fk.permtplcharacteristics.PopulatePermTplCharacteristicsTemplateUuidColumn;
import org.sonar.server.platform.db.migration.version.v84.permtemplatesgroups.AddPrimaryKeyOnUuidColumnOfPermTemplatesGroupsTable;
import org.sonar.server.platform.db.migration.version.v84.permtemplatesgroups.AddUuidColumnToPermTemplatesGroupsTable;
import org.sonar.server.platform.db.migration.version.v84.permtemplatesgroups.DropIdColumnOfPermTemplatesGroupsTable;
import org.sonar.server.platform.db.migration.version.v84.permtemplatesgroups.DropPrimaryKeyOnIdColumnOfPermTemplatesGroupsTable;
import org.sonar.server.platform.db.migration.version.v84.permtemplatesgroups.MakePermTemplatesGroupsUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.permtemplatesgroups.PopulatePermTemplatesGroupsUuid;
import org.sonar.server.platform.db.migration.version.v84.permtemplatesusers.AddPrimaryKeyOnUuidColumnOfPermTemplatesUsersTable;
import org.sonar.server.platform.db.migration.version.v84.permtemplatesusers.AddUuidColumnToPermTemplatesUsersTable;
import org.sonar.server.platform.db.migration.version.v84.permtemplatesusers.DropIdColumnOfPermTemplatesUsersTable;
import org.sonar.server.platform.db.migration.version.v84.permtemplatesusers.DropPrimaryKeyOnIdColumnOfPermTemplatesUsersTable;
import org.sonar.server.platform.db.migration.version.v84.permtemplatesusers.MakePermTemplatesUsersUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.permtemplatesusers.PopulatePermTemplatesUsersUuid;
import org.sonar.server.platform.db.migration.version.v84.permtplcharacteristics.AddPrimaryKeyOnUuidColumnOfPermTplCharacteristicsTable;
import org.sonar.server.platform.db.migration.version.v84.permtplcharacteristics.AddUuidColumnToPermTplCharacteristicsTable;
import org.sonar.server.platform.db.migration.version.v84.permtplcharacteristics.DropIdColumnOfPermTplCharacteristicsTable;
import org.sonar.server.platform.db.migration.version.v84.permtplcharacteristics.DropPrimaryKeyOnIdColumnOfPermTplCharacteristicsTable;
import org.sonar.server.platform.db.migration.version.v84.permtplcharacteristics.MakePermTplCharacteristicsUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.permtplcharacteristics.PopulatePermTplCharacteristicsUuid;
import org.sonar.server.platform.db.migration.version.v84.projectmeasures.AddPrimaryKeyOnUuidColumnOfProjectMeasuresTable;
import org.sonar.server.platform.db.migration.version.v84.projectmeasures.AddUuidColumnToProjectMeasures;
import org.sonar.server.platform.db.migration.version.v84.projectmeasures.DropIdColumnOfProjectMeasuresTable;
import org.sonar.server.platform.db.migration.version.v84.projectmeasures.DropPrimaryKeyOnIdColumnOfProjectMeasuresTable;
import org.sonar.server.platform.db.migration.version.v84.projectmeasures.MakeProjectMeasuresUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.projectmeasures.PopulateProjectMeasureUuid;
import org.sonar.server.platform.db.migration.version.v84.projectqprofiles.AddPrimaryKeyOnUuidColumnOfProjectQProfilesTable;
import org.sonar.server.platform.db.migration.version.v84.projectqprofiles.AddUuidColumnToProjectQProfilesTable;
import org.sonar.server.platform.db.migration.version.v84.projectqprofiles.DropIdColumnOfProjectQProfilesTable;
import org.sonar.server.platform.db.migration.version.v84.projectqprofiles.DropPrimaryKeyOnIdColumnOfProjectQProfilesTable;
import org.sonar.server.platform.db.migration.version.v84.projectqprofiles.MakeProjectQProfilesUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.projectqprofiles.PopulateProjectQProfilesUuid;
import org.sonar.server.platform.db.migration.version.v84.properties.AddPrimaryKeyOnUuidColumnOfPropertiesTable;
import org.sonar.server.platform.db.migration.version.v84.properties.AddUuidColumnToProperties;
import org.sonar.server.platform.db.migration.version.v84.properties.DropIdColumnOfPropertiesTable;
import org.sonar.server.platform.db.migration.version.v84.properties.DropPrimaryKeyOnIdColumnOfPropertiesTable;
import org.sonar.server.platform.db.migration.version.v84.properties.MakePropertiesUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.properties.PopulatePropertiesUuid;
import org.sonar.server.platform.db.migration.version.v84.qualitygateconditions.AddPrimaryKeyOnUuidColumnOfQualityGateConditionsTable;
import org.sonar.server.platform.db.migration.version.v84.qualitygateconditions.AddUuidColumnToQualityGateConditionsTable;
import org.sonar.server.platform.db.migration.version.v84.qualitygateconditions.DropIdColumnOfQualityGateConditionsTable;
import org.sonar.server.platform.db.migration.version.v84.qualitygateconditions.DropPrimaryKeyOnIdColumnOfQualityGateConditionsTable;
import org.sonar.server.platform.db.migration.version.v84.qualitygateconditions.MakeQualityGateConditionsUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.qualitygateconditions.PopulateQualityGateConditionsUuid;
import org.sonar.server.platform.db.migration.version.v84.qualitygates.AddPrimaryKeyOnUuidColumnOfQGatesTable;
import org.sonar.server.platform.db.migration.version.v84.qualitygates.AddQGateUuidColumnForQGateConditions;
import org.sonar.server.platform.db.migration.version.v84.qualitygates.DropIdColumnOfQGateTable;
import org.sonar.server.platform.db.migration.version.v84.qualitygates.DropOrphansQGateConditions;
import org.sonar.server.platform.db.migration.version.v84.qualitygates.DropPrimaryKeyOnIdColumnOfQGatesTable;
import org.sonar.server.platform.db.migration.version.v84.qualitygates.DropQGateIdColumnForQGateConditions;
import org.sonar.server.platform.db.migration.version.v84.qualitygates.DropUniqueIndexOnUuidColumnOfQualityGatesTable;
import org.sonar.server.platform.db.migration.version.v84.qualitygates.MakeQGateUuidColumnNotNullableForQGateConditions;
import org.sonar.server.platform.db.migration.version.v84.qualitygates.PopulateQGateUuidColumnForQGateConditions;
import org.sonar.server.platform.db.migration.version.v84.rules.AddPrimaryKeyOnUuidColumnOfRulesTable;
import org.sonar.server.platform.db.migration.version.v84.rules.AddUuidAndTemplateUuidColumnsToRules;
import org.sonar.server.platform.db.migration.version.v84.rules.DropIdColumnOfRulesTable;
import org.sonar.server.platform.db.migration.version.v84.rules.DropPrimaryKeyOnIdColumnOfRulesTable;
import org.sonar.server.platform.db.migration.version.v84.rules.DropTemplateIdColumnOfRulesTable;
import org.sonar.server.platform.db.migration.version.v84.rules.MakeRulesUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.rules.PopulateRulesTemplateUuid;
import org.sonar.server.platform.db.migration.version.v84.rules.PopulateRulesUuid;
import org.sonar.server.platform.db.migration.version.v84.rules.activerules.AddIndexToActiveRulesTable;
import org.sonar.server.platform.db.migration.version.v84.rules.activerules.AddRuleUuidColumnToActiveRulesTable;
import org.sonar.server.platform.db.migration.version.v84.rules.activerules.DropIndexOnRuleIdColumnOfActiveRulesTable;
import org.sonar.server.platform.db.migration.version.v84.rules.activerules.DropRuleIdColumnOfActiveRulesTable;
import org.sonar.server.platform.db.migration.version.v84.rules.activerules.MakeActiveRulesRuleUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.rules.activerules.PopulateActiveRulesRuleUuidColumn;
import org.sonar.server.platform.db.migration.version.v84.rules.deprecatedrulekeys.AddIndexToDeprecatedRuleKeysTable;
import org.sonar.server.platform.db.migration.version.v84.rules.deprecatedrulekeys.AddRuleUuidColumnToDeprecatedRuleKeysTable;
import org.sonar.server.platform.db.migration.version.v84.rules.deprecatedrulekeys.DropIndexOnRuleIdColumnOfDeprecatedRuleKeysTable;
import org.sonar.server.platform.db.migration.version.v84.rules.deprecatedrulekeys.DropRuleIdColumnOfDeprecatedRuleKeysTable;
import org.sonar.server.platform.db.migration.version.v84.rules.deprecatedrulekeys.MakeDeprecatedRuleKeysRuleUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.rules.deprecatedrulekeys.PopulateDeprecatedRuleKeysRuleUuidColumn;
import org.sonar.server.platform.db.migration.version.v84.rules.issues.AddIndexToIssuesTable;
import org.sonar.server.platform.db.migration.version.v84.rules.issues.AddRuleUuidColumnToIssuesTable;
import org.sonar.server.platform.db.migration.version.v84.rules.issues.DropIndexOnRuleIdColumnOfIssuesTable;
import org.sonar.server.platform.db.migration.version.v84.rules.issues.DropRuleIdColumnOfIssuesTable;
import org.sonar.server.platform.db.migration.version.v84.rules.issues.PopulateIssuesRuleUuidColumn;
import org.sonar.server.platform.db.migration.version.v84.rules.rulesmetadata.AddPrimaryKeyOnUuidAndOrganizationUuidColumnOfRulesMetadataTable;
import org.sonar.server.platform.db.migration.version.v84.rules.rulesmetadata.AddRuleUuidColumnToRulesMetadataTable;
import org.sonar.server.platform.db.migration.version.v84.rules.rulesmetadata.DropPrimaryKeyOnIdColumnOfRulesMetadataTable;
import org.sonar.server.platform.db.migration.version.v84.rules.rulesmetadata.DropRuleIdColumnOfRulesMetadataTable;
import org.sonar.server.platform.db.migration.version.v84.rules.rulesmetadata.MakeRulesMetadataRuleUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.rules.rulesmetadata.PopulateRulesMetadataRuleUuidColumn;
import org.sonar.server.platform.db.migration.version.v84.rules.rulesparameters.AddIndexesToRulesParametersTable;
import org.sonar.server.platform.db.migration.version.v84.rules.rulesparameters.AddRuleUuidColumnToRulesParametersTable;
import org.sonar.server.platform.db.migration.version.v84.rules.rulesparameters.DropIndexesOnRuleIdColumnOfRulesParametersTable;
import org.sonar.server.platform.db.migration.version.v84.rules.rulesparameters.DropRuleIdColumnOfRulesParametersTable;
import org.sonar.server.platform.db.migration.version.v84.rules.rulesparameters.MakeRulesParametersRuleUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.rules.rulesparameters.PopulateRulesParametersRuleUuidColumn;
import org.sonar.server.platform.db.migration.version.v84.rulesparameters.AddPrimaryKeyOnUuidColumnOfRulesParametersTable;
import org.sonar.server.platform.db.migration.version.v84.rulesparameters.AddUuidColumnToRulesParameters;
import org.sonar.server.platform.db.migration.version.v84.rulesparameters.DropIdColumnOfRulesParametersTable;
import org.sonar.server.platform.db.migration.version.v84.rulesparameters.DropPrimaryKeyOnIdColumnOfRulesParametersTable;
import org.sonar.server.platform.db.migration.version.v84.rulesparameters.MakeRulesParametersUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.rulesparameters.PopulateRulesParametersUuid;
import org.sonar.server.platform.db.migration.version.v84.rulesparameters.fk.AddRulesParameterUuidColumnToActiveRuleParameters;
import org.sonar.server.platform.db.migration.version.v84.rulesparameters.fk.DropRulesParameterIdColumnOfActiveRuleParametersTable;
import org.sonar.server.platform.db.migration.version.v84.rulesparameters.fk.MakeActiveRuleParametersRulesParameterUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.rulesparameters.fk.PopulateActiveRuleParametersRulesParameterUuid;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.AddPrimaryKeyOnUuidColumnOfRulesProfilesTable;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.AddUuidColumnToRulesProfilesTable;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.DropIdColumnOfRulesProfilesTable;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.DropKeeColumnOfRulesProfilesTable;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.DropPrimaryKeyOnIdColumnOfRulesProfilesTable;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.DropUniqueIndexOnKeeColumnOfRulesProfilesTable;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.MakeRulesProfilesUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.PopulateRulesProfilesUuid;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.fk.activerules.AddProfileUuidColumnToActiveRulesTable;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.fk.activerules.AddUniqueIndexOnProfileUuidColumnOfActiveRulesTable;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.fk.activerules.DropProfileIdColumnOfActiveRulesTable;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.fk.activerules.DropUniqueIndexOnProfileIdColumnOfActiveRulesTable;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.fk.activerules.MakeActiveRulesProfileUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.fk.activerules.PopulateActiveRulesProfileUuid;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.fk.orgqprofiles.PopulateOrgQProfilesRulesProfileUuid;
import org.sonar.server.platform.db.migration.version.v84.rulesprofiles.fk.qprofilechanges.PopulateQProfileChangesRulesProfileUuid;
import org.sonar.server.platform.db.migration.version.v84.snapshots.issues.AddPrimaryKeyOnUuidColumnOfSnapshotsTable;
import org.sonar.server.platform.db.migration.version.v84.snapshots.issues.DropIdColumnOfSnapshotsTable;
import org.sonar.server.platform.db.migration.version.v84.snapshots.issues.DropPrimaryKeyOnIdColumnOfSnapshotsTable;
import org.sonar.server.platform.db.migration.version.v84.userroles.AddPrimaryKeyOnUuidColumnOfUserRolesTable;
import org.sonar.server.platform.db.migration.version.v84.userroles.AddUuidColumnToUserRolesTable;
import org.sonar.server.platform.db.migration.version.v84.userroles.DropIdColumnOfUserRolesTable;
import org.sonar.server.platform.db.migration.version.v84.userroles.DropPrimaryKeyOnIdColumnOfUserRolesTable;
import org.sonar.server.platform.db.migration.version.v84.userroles.MakeUserRolesUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.userroles.PopulateUserRolesUuid;
import org.sonar.server.platform.db.migration.version.v84.users.AddPrimaryKeyOnUuidColumnOfUsersTable;
import org.sonar.server.platform.db.migration.version.v84.users.DropIdColumnOfUsersTable;
import org.sonar.server.platform.db.migration.version.v84.users.DropPrimaryKeyOnIdColumnOfUsersTable;
import org.sonar.server.platform.db.migration.version.v84.users.DropUniqueIndexOnUuidColumnOfUsersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.groupsusers.AddIndexOnUserUuidOfGroupsUsersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.groupsusers.AddUniqueIndexOnUserUuidAndGroupIdOfGroupsUsersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.groupsusers.AddUserUuidColumnToGroupsUsers;
import org.sonar.server.platform.db.migration.version.v84.users.fk.groupsusers.DropIndexOnUserIdOfGroupsUsersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.groupsusers.DropUniqueIndexOnUserIdAndGroupIdOfGroupsUsersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.groupsusers.DropUserIdColumnOfGroupsUsersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.groupsusers.MakeGroupsUsersUserUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.groupsusers.PopulateGroupsUsersUserUuid;
import org.sonar.server.platform.db.migration.version.v84.users.fk.organizationmembers.AddIndexOnUserUuidOfOrganizationMembersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.organizationmembers.AddPrimaryKeyOnUserUuidAndOrganizationUuidColumnsOfUserRolesTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.organizationmembers.AddUserUuidColumnToOrganizationMembers;
import org.sonar.server.platform.db.migration.version.v84.users.fk.organizationmembers.DropIndexOnUserIdOfOrganizationMembersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.organizationmembers.DropPrimaryKeyOnUserIdAndOrganizationUuidOfOrganizationMembersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.organizationmembers.DropUserIdColumnOfOrganizationMembersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.organizationmembers.MakeOrganizationMembersUserUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.organizationmembers.PopulateOrganizationMembersUserUuid;
import org.sonar.server.platform.db.migration.version.v84.users.fk.permtemplatesusers.AddUserUuidColumnToPermTemplatesUsers;
import org.sonar.server.platform.db.migration.version.v84.users.fk.permtemplatesusers.DropUserIdColumnOfPermTemplatesUsersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.permtemplatesusers.MakePermTemplatesUsersUserUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.permtemplatesusers.PopulatePermTemplatesUsersUserUuid;
import org.sonar.server.platform.db.migration.version.v84.users.fk.properties.AddUserUuidColumnToPropertiesUsers;
import org.sonar.server.platform.db.migration.version.v84.users.fk.properties.DropUserIdColumnOfPropertiesTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.properties.PopulatePropertiesUserUuid;
import org.sonar.server.platform.db.migration.version.v84.users.fk.qprofileeditusers.AddUniqueIndexOnUserUuidAndQProfileUuidOfQProfileEditUsersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.qprofileeditusers.AddUserUuidColumnToQProfileEditUsers;
import org.sonar.server.platform.db.migration.version.v84.users.fk.qprofileeditusers.DropUniqueIndexOnUserIdAndQProfileUuidOfQProfileEditUsersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.qprofileeditusers.DropUserIdColumnOfQProfileEditUsersTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.qprofileeditusers.MakeQProfileEditUsersUserUuidColumnNotNullable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.qprofileeditusers.PopulateQProfileEditUsersUserUuid;
import org.sonar.server.platform.db.migration.version.v84.users.fk.userroles.AddIndexOnUserUuidOfUserRolesTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.userroles.AddUserUuidColumnToUserRoles;
import org.sonar.server.platform.db.migration.version.v84.users.fk.userroles.DropIndexOnUserIdOfUserRolesTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.userroles.DropUserIdColumnOfUserRolesTable;
import org.sonar.server.platform.db.migration.version.v84.users.fk.userroles.PopulateUserRolesUserUuid;
import org.sonar.server.platform.db.migration.version.v84.usertokens.AddPrimaryKeyOnUuidColumnOfUserTokensTable;
import org.sonar.server.platform.db.migration.version.v84.usertokens.AddUuidColumnToUserTokens;
import org.sonar.server.platform.db.migration.version.v84.usertokens.DropIdColumnOfUserTokensTable;
import org.sonar.server.platform.db.migration.version.v84.usertokens.DropPrimaryKeyOnIdColumnOfUserTokensTable;
import org.sonar.server.platform.db.migration.version.v84.usertokens.MakeUserTokensUuidNotNullable;
import org.sonar.server.platform.db.migration.version.v84.usertokens.PopulateUserTokensUuid;

public class DbVersion84 implements DbVersion {
  @Override
  public void addSteps(MigrationStepRegistry registry) {
    registry
      // Migration on EVENTS table
      .add(3400, "Drop primary key on 'ID' column of 'EVENTS' table", DropPrimaryKeyOnIdColumnOfEventsTable.class)
      .add(3401, "Add primary key on 'UUID' column of 'EVENTS' table", AddPrimaryKeyOnUuidColumnOfEventsTable.class)
      .add(3402, "Drop column 'ID' of 'EVENTS' table", DropIdColumnOfEventsTable.class)

      // Migrations of NOTIFICATIONS table
      .add(3403, "Add 'uuid' and 'createdAt' columns for notifications", AddUuidAndCreatedAtColumnsToNotification.class)
      .add(3404, "Populate 'uuid' and 'createdAt columns for notifications", PopulateNotificationUuidAndCreatedAt.class)
      .add(3405, "Make 'uuid' and 'createdAt' column not nullable for notifications", MakeNotificationUuidAndCreatedAtColumnsNotNullable.class)
      .add(3406, "Drop primary key on 'ID' column of 'NOTIFICATIONS' table", DropPrimaryKeyOnIdColumnOfNotificationTable.class)
      .add(3407, "Add primary key on 'UUID' column of 'NOTIFICATIONS' table", AddPrimaryKeyOnUuidColumnOfNotificationTable.class)
      .add(3408, "Drop column 'ID' of 'NOTIFICATIONS' table", DropIdColumnOfNotificationTable.class)

      // Migration on ISSUES table
      .add(3409, "Drop primary key on 'ID' column of 'ISSUES' table", DropPrimaryKeyOnIdColumnOfIssuesTable.class)
      .add(3410, "Add primary key on 'KEE' column of 'ISSUES' table", AddPrimaryKeyOnKeeColumnOfIssuesTable.class)
      .add(3411, "Drop column 'ID' of 'ISSUES' table", DropIdColumnOfIssuesTable.class)

      // Migration on SNAPSHOTS table
      .add(3412, "Drop primary key on 'ID' column of 'SNAPSHOTS' table", DropPrimaryKeyOnIdColumnOfSnapshotsTable.class)
      .add(3413, "Add primary key on 'UUID' column of 'SNAPSHOTS' table", AddPrimaryKeyOnUuidColumnOfSnapshotsTable.class)
      .add(3414, "Drop column 'ID' of 'SNAPSHOTS' table", DropIdColumnOfSnapshotsTable.class)

      // Migration on CE_QUEUE table
      .add(3415, "Drop unique index on 'uuid' column of 'CE_QUEUE' table", DropUniqueIndexOnUuidColumnOfCeQueueTable.class)
      .add(3416, "Drop primary key on 'ID' column of 'CE_QUEUE' table", DropPrimaryKeyOnIdColumnOfCeQueueTable.class)
      .add(3417, "Add primary key on 'UUID' column of 'CE_QUEUE' table", AddPrimaryKeyOnUuidColumnOfCeQueueTable.class)
      .add(3418, "Drop column 'ID' of 'CE_QUEUE' table", DropIdColumnOfCeQueueTable.class)

      // Migration on CE_ACTIVITY table
      .add(3419, "Drop primary key on 'ID' column of 'CE_ACTIVITY' table", DropPrimaryKeyOnIdColumnOfCeActivityTable.class)
      .add(3420, "Add primary key on 'UUID' column of 'CE_ACTIVITY' table", AddPrimaryKeyOnUuidColumnOfCeActivityTable.class)
      .add(3421, "Drop column 'ID' of 'CE_ACTIVITY' table", DropIdColumnOfCeActivityTable.class)

      // Migration of DUPLICATIONS_INDEX table
      .add(3422, "Add 'uuid' columns for DUPLICATIONS_INDEX", AddUuidToDuplicationsIndexTable.class)
      .add(3423, "Populate 'uuid' columns for DUPLICATIONS_INDEX", PopulateDuplicationsIndexUuid.class)
      .add(3424, "Make 'uuid' column not nullable for DUPLICATIONS_INDEX", MakeDuplicationsIndexUuidColumnNotNullable.class)
      .add(3425, "Drop primary key on 'ID' column of 'DUPLICATIONS_INDEX' table", DropPrimaryKeyOnIdColumnOfDuplicationsIndexTable.class)
      .add(3426, "Add primary key on 'UUID' column of 'DUPLICATIONS_INDEX' table", AddPrimaryKeyOnUuidColumnOfDuplicationsIndexTable.class)
      .add(3427, "Drop column 'ID' of 'DUPLICATIONS_INDEX' table", DropIdColumnOfDuplicationsIndexTable.class)

      // Migration of ACTIVE_RULE_PARAMS table
      .add(3428, "Add 'uuid' column for 'ACTIVE_RULE_PARAMS' table", AddUuidColumnToActiveRuleParametersTable.class)
      .add(3429, "Populate 'uuid' column for 'ACTIVE_RULE_PARAMS' table", PopulateActiveRuleParametersUuid.class)
      .add(3430, "Make 'uuid' column not nullable for 'ACTIVE_RULE_PARAMS' table", MakeActiveRuleParametersUuidColumnNotNullable.class)
      .add(3431, "Drop primary key on 'ID' column of 'ACTIVE_RULE_PARAMS' table", DropPrimaryKeyOnIdColumnOfActiveRuleParametersTable.class)
      .add(3432, "Add primary key on 'UUID' column of 'ACTIVE_RULE_PARAMS' table", AddPrimaryKeyOnUuidColumnOfActiveRuleParametersTable.class)
      .add(3433, "Drop column 'ID' of 'ACTIVE_RULE_PARAMS' table", DropIdColumnOfActiveRuleParametersTable.class)

      // Migration on PROJECT_MEASURES table
      .add(3434, "Add 'uuid' columns for 'PROJECT_MEASURES'", AddUuidColumnToProjectMeasures.class)
      .add(3435, "Populate 'uuid' column for 'PROJECT_MEASURES'", PopulateProjectMeasureUuid.class)
      .add(3436, "Make 'uuid' column not nullable for 'PROJECT_MEASURES'", MakeProjectMeasuresUuidColumnNotNullable.class)
      .add(3437, "Drop primary key on 'ID' column of 'PROJECT_MEASURES' table", DropPrimaryKeyOnIdColumnOfProjectMeasuresTable.class)
      .add(3438, "Add primary key on 'UUID' column of 'PROJECT_MEASURES' table", AddPrimaryKeyOnUuidColumnOfProjectMeasuresTable.class)
      .add(3439, "Drop column 'ID' of 'PROJECT_MEASURES' table", DropIdColumnOfProjectMeasuresTable.class)

      // Migration of USER_TOKENS table
      .add(3440, "Add 'UUID' column on 'USER_TOKENS' table", AddUuidColumnToUserTokens.class)
      .add(3441, "Populate 'uuid' for 'USER_TOKENS'", PopulateUserTokensUuid.class)
      .add(3442, "Make 'uuid' column not nullable for user_tokens", MakeUserTokensUuidNotNullable.class)
      .add(3443, "Drop primary key on 'ID' column of 'USER_TOKENS' table", DropPrimaryKeyOnIdColumnOfUserTokensTable.class)
      .add(3444, "Add primary key on 'UUID' column of 'USER_TOKENS' table", AddPrimaryKeyOnUuidColumnOfUserTokensTable.class)
      .add(3445, "Drop column 'ID' of 'USER_TOKENS' table", DropIdColumnOfUserTokensTable.class)

      // Migration on PROJECT_QPROFILES table
      .add(3446, "Add 'uuid' column for 'PROJECT_QPROFILES'", AddUuidColumnToProjectQProfilesTable.class)
      .add(3447, "Populate 'uuid' column for 'PROJECT_QPROFILES'", PopulateProjectQProfilesUuid.class)
      .add(3448, "Make 'uuid' column not nullable for 'PROJECT_QPROFILES'", MakeProjectQProfilesUuidColumnNotNullable.class)
      .add(3449, "Drop primary key on 'ID' column of 'PROJECT_QPROFILES' table", DropPrimaryKeyOnIdColumnOfProjectQProfilesTable.class)
      .add(3450, "Add primary key on 'UUID' column of 'PROJECT_QPROFILES' table", AddPrimaryKeyOnUuidColumnOfProjectQProfilesTable.class)
      .add(3451, "Drop column 'ID' of 'PROJECT_QPROFILES' table", DropIdColumnOfProjectQProfilesTable.class)

      // Migration of MANUAL_MEASURES table
      .add(3452, "Add 'uuid' column for 'MANUAL_MEASURES'", AddUuidColumnToManualMeasures.class)
      .add(3453, "Populate 'uuid' column for 'MANUAL_MEASURES'", PopulateManualMeasureUuid.class)
      .add(3454, "Make 'uuid' column not nullable for 'MANUAL_MEASURES'", MakeManualMeasuresUuidColumnNotNullable.class)
      .add(3455, "Drop primary key on 'ID' column of 'MANUAL_MEASURES' table", DropPrimaryKeyOnIdColumnOfManualMeasuresTable.class)
      .add(3456, "Add primary key on 'UUID' column of 'MANUAL_MEASURES' table", AddPrimaryKeyOnUuidColumnOfManualMeasuresTable.class)
      .add(3457, "Drop column 'ID' of 'MANUAL_MEASURES' table", DropIdColumnOfManualMeasuresTable.class)

      // Migration of GROUP_ROLES table
      .add(3458, "Add 'UUID' column on 'GROUP_ROLES' table", AddUuidColumnToGroupRolesTable.class)
      .add(3459, "Populate 'uuid' for 'GROUP_ROLES'", PopulateGroupRolesUuid.class)
      .add(3460, "Make 'uuid' column not nullable for 'GROUP_ROLES'", MakeGroupRolesUuidColumnNotNullable.class)
      .add(3461, "Drop primary key on 'ID' column of 'GROUP_ROLES' table", DropPrimaryKeyOnIdColumnOfGroupRolesTable.class)
      .add(3462, "Add primary key on 'UUID' column of 'GROUP_ROLES' table", AddPrimaryKeyOnUuidColumnOfGroupRolesTable.class)
      .add(3463, "Drop column 'ID' of 'GROUP_ROLES' table", DropIdColumnOfGroupRolesTable.class)

      // Migration of USER_ROLES table
      .add(3464, "Add 'UUID' column on 'USER_ROLES' table", AddUuidColumnToUserRolesTable.class)
      .add(3465, "Populate 'uuid' for 'USER_ROLES'", PopulateUserRolesUuid.class)
      .add(3466, "Make 'uuid' column not nullable for 'USER_ROLES'", MakeUserRolesUuidColumnNotNullable.class)
      .add(3467, "Drop primary key on 'ID' column of 'USER_ROLES' table", DropPrimaryKeyOnIdColumnOfUserRolesTable.class)
      .add(3468, "Add primary key on 'UUID' column of 'USER_ROLES' table", AddPrimaryKeyOnUuidColumnOfUserRolesTable.class)
      .add(3469, "Drop column 'ID' of 'USER_ROLES' table", DropIdColumnOfUserRolesTable.class)

      // Migration of FILE_SOURCES table
      .add(3470, "Add 'UUID' column on 'FILE_SOURCES' table", AddUuidColumnToFileSourcesTable.class)
      .add(3471, "Populate 'uuid' for 'FILE_SOURCES'", PopulateFileSourcesUuid.class)
      .add(3472, "Make 'uuid' column not nullable for 'FILE_SOURCES'", MakeFileSourcesUuidColumnNotNullable.class)
      .add(3473, "Drop primary key on 'ID' column of 'FILE_SOURCES' table", DropPrimaryKeyOnIdColumnOfFileSourcesTable.class)
      .add(3474, "Add primary key on 'UUID' column of 'FILE_SOURCES' table", AddPrimaryKeyOnUuidColumnOfFileSourcesTable.class)
      .add(3475, "Drop column 'ID' of 'FILE_SOURCES' table", DropIdColumnOfFileSourcesTable.class)

      // Migration of ISSUE_CHANGES table
      .add(3476, "Add 'UUID' column on 'ISSUE_CHANGES' table", AddUuidColumnToIssueChangesTable.class)
      .add(3477, "Populate 'uuid' for 'ISSUE_CHANGES'", PopulateIssueChangesUuid.class)
      .add(3478, "Make 'uuid' column not nullable for 'ISSUE_CHANGES'", MakeIssueChangesUuidColumnNotNullable.class)
      .add(3479, "Drop primary key on 'ID' column of 'ISSUE_CHANGES' table", DropPrimaryKeyOnIdColumnOfIssueChangesTable.class)
      .add(3480, "Add primary key on 'UUID' column of 'ISSUE_CHANGES' table", AddPrimaryKeyOnUuidColumnOfIssueChangesTable.class)
      .add(3481, "Drop column 'ID' of 'ISSUE_CHANGES' table", DropIdColumnOfIssueChangesTable.class)

      // Migration of QUALITY_GATE_CONDITIONS table
      .add(3482, "Add 'UUID' column on 'QUALITY_GATE_CONDITIONS' table", AddUuidColumnToQualityGateConditionsTable.class)
      .add(3483, "Populate 'uuid' for 'QUALITY_GATE_CONDITIONS'", PopulateQualityGateConditionsUuid.class)
      .add(3484, "Make 'uuid' column not nullable for 'QUALITY_GATE_CONDITIONS'", MakeQualityGateConditionsUuidColumnNotNullable.class)
      .add(3485, "Drop primary key on 'ID' column of 'QUALITY_GATE_CONDITIONS' table", DropPrimaryKeyOnIdColumnOfQualityGateConditionsTable.class)
      .add(3486, "Add primary key on 'UUID' column of 'QUALITY_GATE_CONDITIONS' table", AddPrimaryKeyOnUuidColumnOfQualityGateConditionsTable.class)
      .add(3487, "Drop column 'ID' of 'QUALITY_GATE_CONDITIONS' table", DropIdColumnOfQualityGateConditionsTable.class)

      // Migration of PERM_TEMPLATES_GROUPS table
      .add(3488, "Add 'UUID' column on 'PERM_TEMPLATES_GROUPS' table", AddUuidColumnToPermTemplatesGroupsTable.class)
      .add(3489, "Populate 'uuid' for 'PERM_TEMPLATES_GROUPS'", PopulatePermTemplatesGroupsUuid.class)
      .add(3490, "Make 'uuid' column not nullable for 'PERM_TEMPLATES_GROUPS'", MakePermTemplatesGroupsUuidColumnNotNullable.class)
      .add(3491, "Drop primary key on 'ID' column of 'PERM_TEMPLATES_GROUPS' table", DropPrimaryKeyOnIdColumnOfPermTemplatesGroupsTable.class)
      .add(3492, "Add primary key on 'UUID' column of 'PERM_TEMPLATES_GROUPS' table", AddPrimaryKeyOnUuidColumnOfPermTemplatesGroupsTable.class)
      .add(3493, "Drop column 'ID' of 'PERM_TEMPLATES_GROUPS' table", DropIdColumnOfPermTemplatesGroupsTable.class)

      // Migration of PERM_TPL_CHARACTERISTICS table
      .add(3494, "Add 'UUID' column on 'PERM_TPL_CHARACTERISTICS' table", AddUuidColumnToPermTplCharacteristicsTable.class)
      .add(3495, "Populate 'uuid' for 'PERM_TPL_CHARACTERISTICS'", PopulatePermTplCharacteristicsUuid.class)
      .add(3496, "Make 'uuid' column not nullable for 'PERM_TPL_CHARACTERISTICS'", MakePermTplCharacteristicsUuidColumnNotNullable.class)
      .add(3497, "Drop primary key on 'ID' column of 'PERM_TPL_CHARACTERISTICS' table", DropPrimaryKeyOnIdColumnOfPermTplCharacteristicsTable.class)
      .add(3498, "Add primary key on 'UUID' column of 'PERM_TPL_CHARACTERISTICS' table", AddPrimaryKeyOnUuidColumnOfPermTplCharacteristicsTable.class)
      .add(3499, "Drop column 'ID' of 'PERM_TPL_CHARACTERISTICS' table", DropIdColumnOfPermTplCharacteristicsTable.class)

      // Migration of PERM_TEMPLATES_USERS table
      .add(3500, "Add 'UUID' column on 'PERM_TEMPLATES_USERS' table", AddUuidColumnToPermTemplatesUsersTable.class)
      .add(3501, "Populate 'uuid' for 'PERM_TEMPLATES_USERS'", PopulatePermTemplatesUsersUuid.class)
      .add(3502, "Make 'uuid' column not nullable for 'PERM_TEMPLATES_USERS'", MakePermTemplatesUsersUuidColumnNotNullable.class)
      .add(3503, "Drop primary key on 'ID' column of 'PERM_TEMPLATES_USERS' table", DropPrimaryKeyOnIdColumnOfPermTemplatesUsersTable.class)
      .add(3504, "Add primary key on 'UUID' column of 'PERM_TEMPLATES_USERS' table", AddPrimaryKeyOnUuidColumnOfPermTemplatesUsersTable.class)
      .add(3505, "Drop column 'ID' of 'PERM_TEMPLATES_USERS' table", DropIdColumnOfPermTemplatesUsersTable.class)

      // Migration of ACTIVE_RULES table
      .add(3506, "Add 'UUID' column on 'ACTIVE_RULES' table", AddUuidColumnToActiveRulesTable.class)
      .add(3507, "Populate 'uuid' for 'ACTIVE_RULES'", PopulateActiveRulesUuid.class)
      .add(3508, "Make 'uuid' column not nullable for 'ACTIVE_RULES'", MakeActiveRulesUuidColumnNotNullable.class)

      // Migration of FK in ACTIVE_RULE_PARAMETERS to ACTIVE_RULES
      .add(3509, "Add 'active_rule_uuid' column on 'ACTIVE_RULE_PARAMETERS' table", AddActiveRuleUuidColumnToActiveRuleParameters.class)
      .add(3510, "Populate 'active_rule_uuid' for 'ACTIVE_RULE_PARAMETERS'", PopulateActiveRuleParametersActiveRuleUuid.class)
      .add(3511, "Make 'active_rule_uuid' column not nullable for 'ACTIVE_RULE_PARAMETERS'", MakeActiveRuleParametersActiveRuleUuidNotNullable.class)
      .add(3512, "Drop index on 'active_rule_id' column of 'ACTIVE_RULE_PARAMETERS' table", DropIndexOnActiveRuleIdOfActiveRuleParametersTable.class)
      .add(3513, "Add index on 'active_rule_uuid' column of 'ACTIVE_RULE_PARAMETERS' table", AddIndexOnActiveRuleUuidOfActiveRuleParametersTable.class)

      // Finish migration of ACTIVE_RULES
      .add(3514, "Drop primary key on 'ID' column of 'ACTIVE_RULES' table", DropPrimaryKeyOnIdColumnOfActiveRulesTable.class)
      .add(3515, "Add primary key on 'UUID' column of 'ACTIVE_RULES' table", AddPrimaryKeyOnUuidColumnOfActiveRulesTable.class)
      .add(3516, "Drop column 'ID' of 'ACTIVE_RULES' table", DropIdColumnOfActiveRulesTable.class)
      .add(3517, "Drop column 'active_rule_id' of 'ACTIVE_RULE_PARAMETERS' table", DropActiveRuleIdColumnOfActiveRuleParametersTable.class)

      // Migration on RULES_PARAMETERS table - populate uuid column
      .add(3518, "Add 'uuid' column for 'RULES_PARAMETERS'", AddUuidColumnToRulesParameters.class)
      .add(3519, "Populate 'uuid' column for 'RULES_PARAMETERS'", PopulateRulesParametersUuid.class)
      .add(3520, "Make 'uuid' column not nullable for 'RULES_PARAMETERS'", MakeRulesParametersUuidColumnNotNullable.class)

      // Migration of ACTIVE_RULE_PARAMS FK to RULES_PARAMETERS, switch from ruleParamId to ruleParamUuid
      .add(3521, "Add 'rules_parameter_uuid' column for 'ACTIVE_RULE_PARAMS' table", AddRulesParameterUuidColumnToActiveRuleParameters.class)
      .add(3522, "Populate 'rules_parameter_uuid' column for 'ACTIVE_RULE_PARAMS' table", PopulateActiveRuleParametersRulesParameterUuid.class)
      .add(3523, "Make 'rules_parameter_uuid' column not nullable for 'ACTIVE_RULE_PARAMS' table", MakeActiveRuleParametersRulesParameterUuidColumnNotNullable.class)
      .add(3524, "Drop column 'rules_parameter_id' of 'ACTIVE_RULE_PARAMS' table", DropRulesParameterIdColumnOfActiveRuleParametersTable.class)

      // Migration on RULES_PARAMETERS table change PK
      .add(3525, "Drop primary key on 'ID' column of 'RULES_PARAMETERS' table", DropPrimaryKeyOnIdColumnOfRulesParametersTable.class)
      .add(3526, "Add primary key on 'UUID' column of 'RULES_PARAMETERS' table", AddPrimaryKeyOnUuidColumnOfRulesParametersTable.class)
      .add(3527, "Drop column 'ID' of 'RULES_PARAMETERS' table", DropIdColumnOfRulesParametersTable.class)

      // Migration of METRICS table
      .add(3528, "Add 'UUID' column on 'METRICS' table", AddUuidColumnToMetricsTable.class)
      .add(3529, "Populate 'uuid' for 'METRICS'", PopulateMetricsUuid.class)
      .add(3530, "Make 'uuid' column not nullable for 'METRICS'", MakeMetricsUuidColumnNotNullable.class)

      // Migration of FK in PROJECT_MEASURES to METRICS
      .add(3531, "Add 'metric_uuid' column on 'PROJECT_MEASURES' table", AddMetricUuidColumnToProjectMeasures.class)
      .add(3532, "Populate 'metric_uuid' for 'PROJECT_MEASURES'", PopulateProjectMeasuresMetricUuid.class)
      .add(3533, "Make 'metric_uuid' column not nullable for 'PROJECT_MEASURES'", MakeProjectMeasuresMetricUuidNotNullable.class)
      .add(3534, "Drop index on 'metric_id' and 'analysis_uuid' columns of 'PROJECT_MEASURES' table", DropIndexOnMetricIdOfProjectMeasuresTable.class)
      .add(3535, "Add index on 'metric_uuid' and 'analysis_uuid' columns of 'PROJECT_MEASURES' table", AddIndexOnMetricUuidOfProjectMeasuresTable.class)

      // Migration of FK in QUALITY_GATE_CONDITIONS to METRICS
      .add(3536, "Add 'metric_uuid' column on 'QUALITY_GATE_CONDITIONS' table", AddMetricUuidColumnToQualityGateConditions.class)
      .add(3537, "Populate 'metric_uuid' for 'QUALITY_GATE_CONDITIONS'", PopulateQualityGateConditionsMetricUuid.class)
      .add(3538, "Make 'metric_uuid' column not nullable for 'QUALITY_GATE_CONDITIONS'", MakeQualityGateConditionsMetricUuidNotNullable.class)

      // Migration of FK in LIVE_MEASURES to METRICS
      .add(3539, "Add 'metric_uuid' column on 'LIVE_MEASURES' table", AddMetricUuidColumnToLiveMeasures.class)
      .add(3540, "Populate 'metric_uuid' for 'LIVE_MEASURES'", PopulateLiveMeasuresMetricUuid.class)
      .add(3541, "Make 'metric_uuid' column not nullable for 'LIVE_MEASURES'", MakeLiveMeasuresMetricUuidNotNullable.class)
      .add(3542, "Drop index on 'metric_id' column of 'LIVE_MEASURES' table", DropIndexOnMetricIdOfLiveMeasuresTable.class)
      .add(3543, "Add index on 'metric_uuid' column of 'LIVE_MEASURES' table", AddIndexOnMetricUuidOfLiveMeasuresTable.class)

      // Migration of FK in MANUAL_MEASURES to METRICS
      .add(3544, "Add 'metric_uuid' column on 'MANUAL_MEASURES' table", AddMetricUuidColumnToManualMeasures.class)
      .add(3545, "Populate 'metric_uuid' for 'MANUAL_MEASURES'", PopulateManualMeasuresMetricUuid.class)
      .add(3546, "Make 'metric_uuid' column not nullable for 'MANUAL_MEASURES'", MakeManualMeasuresMetricUuidNotNullable.class)

      // Finish migration of METRICS
      .add(3547, "Drop primary key on 'ID' column of 'METRICS' table", DropPrimaryKeyOnIdColumnOfMetricsTable.class)
      .add(3548, "Add primary key on 'UUID' column of 'METRICS' table", AddPrimaryKeyOnUuidColumnOfMetricsTable.class)
      .add(3549, "Drop column 'METRIC_ID' of 'PROJECT_MEASURES' table", DropMetricIdColumnOfProjectMeasuresTable.class)
      .add(3550, "Drop column 'METRIC_ID' of 'QUALITY_GATE_CONDITIONS' table", DropMetricIdColumnOfQualityGateConditionsTable.class)
      .add(3551, "Drop column 'METRIC_ID' of 'LIVE_MEASURES' table", DropMetricIdColumnOfLiveMeasuresTable.class)
      .add(3552, "Drop column 'METRIC_ID' of 'MANUAL_MEASURES' table", DropMetricIdColumnOfManualMeasuresTable.class)
      .add(3553, "Drop column 'ID' of 'METRICS' table", DropIdColumnOfMetricsTable.class)

      // Migration of PERMISSION_TEMPLATES table
      .add(3554, "Add 'UUID' column on 'PERMISSION_TEMPLATES' table", AddUuidColumnToPermissionTemplates.class)
      .add(3555, "Populate 'uuid' for 'PERMISSION_TEMPLATES'", PopulatePermissionTemplatesUuid.class)
      .add(3556, "Make 'uuid' column not nullable for user_tokens", MakePermissionTemplateUuidColumnNotNullable.class)

      // Migration of PERM_TEMPLATES_GROUPS FK to PERMISSION_TEMPLATES, switch from templateId to templateUuid
      .add(3557, "Add 'template_uuid' column for 'PERM_TEMPLATES_GROUPS' table", AddTemplateUuidColumnToPermTemplatesGroups.class)
      .add(3558, "Populate 'template_uuid' column for 'PERM_TEMPLATES_GROUPS' table", PopulatePermTemplatesGroupsTemplateUuidColumn.class)
      .add(3559, "Make 'template_uuid' column not nullable for 'PERM_TEMPLATES_GROUPS' table", MakePermTemplatesGroupsTemplateUuidColumnNotNullable.class)
      .add(3560, "Drop column 'template_id' of 'PERM_TEMPLATES_GROUPS' table", DropTemplateIdColumnOfPermTemplatesGroupsTable.class)

      // Migration of PERM_TEMPLATES_USERS FK to PERMISSION_TEMPLATES, switch from templateId to templateUuid
      .add(3561, "Add 'template_uuid' column for 'PERM_TEMPLATES_USERS' table", AddTemplateUuidColumnToPermTemplatesUsers.class)
      .add(3562, "Populate 'template_uuid' column for 'PERM_TEMPLATES_USERS' table", PopulatePermTemplatesUsersTemplateUuidColumn.class)
      .add(3563, "Make 'template_uuid' column not nullable for 'PERM_TEMPLATES_USERS' table", MakePermTemplatesUsersTemplateUuidColumnNotNullable.class)
      .add(3564, "Drop column 'template_id' of 'PERM_TEMPLATES_USERS' table", DropTemplateIdColumnOfPermTemplatesUsersTable.class)

      // Migration of PERM_TPL_CHARACTERISTICS FK to PERMISSION_TEMPLATES, switch from templateId to templateUuid
      .add(3565, "Add 'template_uuid' column for 'PERM_TPL_CHARACTERISTICS' table", AddTemplateUuidColumnToPermTplCharacteristics.class)
      .add(3566, "Populate 'template_uuid' column for 'PERM_TPL_CHARACTERISTICS' table", PopulatePermTplCharacteristicsTemplateUuidColumn.class)
      .add(3567, "Make 'template_uuid' column not nullable for 'PERM_TPL_CHARACTERISTICS' table", MakePermTplCharacteristicsTemplateUuidColumnNotNullable.class)
      .add(3568, "Drop unique constraint on 'template_id', 'permission_key' columns 'PERM_TPL_CHARACTERISTICS' table",
        DropUniqueIndexOnTemplateIdAndPermissionKeyColumnsOfPermTplCharacteristicsTable.class)
      .add(3569, "Add unique constraint on 'template_uuid', 'permission_key' columns 'PERM_TPL_CHARACTERISTICS' table",
        AddUniqueIndexOnTemplateUuidAndPermissionKeyColumnsOfPermTplCharacteristicsTable.class)

      .add(3570, "Drop column 'template_id' of 'PERM_TPL_CHARACTERISTICS' table", DropTemplateIdColumnOfPermTplCharacteristicsTable.class)

      .add(3571, "Drop primary key on 'ID' column of 'PERMISSION_TEMPLATES' table", DropPrimaryKeyOnIdColumnOfPermissionTemplatesTable.class)
      .add(3572, "Add primary key on 'UUID' column of 'PERMISSION_TEMPLATES' table", AddPrimaryKeyOnUuidColumnOfPermissionTemplatesTable.class)

      .add(3573, "Drop column 'ID' of 'PERMISSION_TEMPLATES' table", DropIdColumnOfPermissionTemplatesTable.class)
      .add(3574, "Drop column 'KEE' of 'PERMISSION_TEMPLATES' table", DropKeeColumnOfPermissionTemplatesTable.class)

      // Migration on RULES_PROFILES table
      .add(3575, "Add 'uuid' column for 'RULES_PROFILES'", AddUuidColumnToRulesProfilesTable.class)
      .add(3576, "Populate 'uuid' column for 'RULES_PROFILES'", PopulateRulesProfilesUuid.class)
      .add(3577, "Make 'uuid' column not nullable for 'RULES_PROFILES'", MakeRulesProfilesUuidColumnNotNullable.class)

      // Migration of ORG_QPROFILES FK to RULES_PROFILES
      .add(3578, "Populate 'rules_profile_uuid' column for 'ORG_QPROFILES' table", PopulateOrgQProfilesRulesProfileUuid.class)

      // Migration of QPROFILE_CHANGES FK to RULES_PROFILES
      .add(3579, "Populate 'rules_profile_uuid' column for 'QPROFILE_CHANGES' table", PopulateQProfileChangesRulesProfileUuid.class)

      // Migration of ACTIVE_RULES FK to RULES_PROFILES, switch from profile_id to profile_uuid
      .add(3580, "Add 'profile_uuid' column for 'ACTIVE_RULES' table", AddProfileUuidColumnToActiveRulesTable.class)
      .add(3581, "Populate 'profile_uuid' column for 'ACTIVE_RULES' table", PopulateActiveRulesProfileUuid.class)
      .add(3582, "Make 'profile_uuid' column not nullable for 'ACTIVE_RULES' table", MakeActiveRulesProfileUuidColumnNotNullable.class)

      .add(3583, "Drop unique constraint on 'profile_id', 'rule_id' columns 'ACTIVE_RULES' table", DropUniqueIndexOnProfileIdColumnOfActiveRulesTable.class)
      .add(3584, "Add unique constraint on 'profile_uuid', 'rule_id' columns 'ACTIVE_RULES' table", AddUniqueIndexOnProfileUuidColumnOfActiveRulesTable.class)

      .add(3585, "Drop column 'profile_id' of 'ACTIVE_RULES' table", DropProfileIdColumnOfActiveRulesTable.class)

      .add(3586, "Drop unique constraint on 'kee' columns 'RULES_PROFILES' table", DropUniqueIndexOnKeeColumnOfRulesProfilesTable.class)
      .add(3587, "Drop column 'kee' of 'RULES_PROFILES' table", DropKeeColumnOfRulesProfilesTable.class)

      .add(3588, "Drop primary key on 'ID' column of 'RULES_PROFILES' table", DropPrimaryKeyOnIdColumnOfRulesProfilesTable.class)
      .add(3589, "Add primary key on 'UUID' column of 'RULES_PROFILES' table", AddPrimaryKeyOnUuidColumnOfRulesProfilesTable.class)
      .add(3590, "Drop column 'ID' of 'RULES_PROFILES' table", DropIdColumnOfRulesProfilesTable.class)

      // Migration of PROPERTIES table
      .add(3591, "Add 'uuid' column for 'PROPERTIES'", AddUuidColumnToProperties.class)
      .add(3592, "Populate 'uuid' for 'PROPERTIES'", PopulatePropertiesUuid.class)
      .add(3593, "Make 'uuid' column not nullable for 'PROPERTIES'", MakePropertiesUuidColumnNotNullable.class)
      .add(3594, "Drop primary key on 'ID' column of 'PROPERTIES' table", DropPrimaryKeyOnIdColumnOfPropertiesTable.class)
      .add(3595, "Add primary key on 'UUID' column of 'PROPERTIES' table", AddPrimaryKeyOnUuidColumnOfPropertiesTable.class)
      .add(3596, "Drop column 'ID' of 'PROPERTIES' table", DropIdColumnOfPropertiesTable.class)

      // Migration of GROUPS table
      .add(3597, "Add 'UUID' column on 'GROUPS' table", AddUuidColumnToGroupsTable.class)
      .add(3598, "Populate 'uuid' for 'GROUPS'", PopulateGroupsUuid.class)
      .add(3599, "Make 'uuid' column not nullable for 'GROUPS'", MakeGroupsUuidColumnNotNullable.class)

      // Migration of FK in GROUP_ROLES to GROUPS
      .add(3600, "Add 'group_uuid' column on 'GROUP_ROLES' table", AddGroupUuidColumnToGroupRoles.class)
      .add(3601, "Populate 'group_uuid' for 'GROUP_ROLES'", PopulateGroupRolesGroupUuid.class)
      .add(3602, "Drop index on 'group_id' column of 'GROUP_ROLES' table", DropIndexOnGroupIdOfGroupRolesTable.class)
      .add(3603, "Add index on 'group_uuid' column of 'GROUP_ROLES' table", AddIndexOnGroupUuidOfGroupRolesTable.class)

      // Migration of FK in GROUPS_USERS to GROUPS
      .add(3604, "Add 'group_uuid' column on 'GROUPS_USERS' table", AddGroupUuidColumnToGroupsUsers.class)
      .add(3605, "Populate 'group_uuid' for 'GROUPS_USERS'", PopulateGroupsUsersGroupUuid.class)
      .add(3606, "Make 'group_uuid' column not nullable for 'GROUPS_USERS'", MakeGroupsUsersGroupUuidNotNullable.class)
      .add(3607, "Drop index on 'group_id' column of 'GROUPS_USERS' table", DropIndexOnGroupIdOfGroupsUsersTable.class)
      .add(3608, "Add index on 'group_uuid' column of 'GROUPS_USERS' table", AddIndexOnGroupUuidOfGroupsUsersTable.class)

      // Migration of FK in ORGANIZATIONS to GROUPS
      .add(3609, "Add 'default_group_uuid' column on 'ORGANIZATIONS' table", AddDefaultGroupUuidColumnToOrganizations.class)
      .add(3610, "Populate 'default_group_uuid' for 'ORGANIZATIONS'", PopulateOrganizationsDefaultGroupUuid.class)

      // Migration of FK in PERM_TEMPLATES_GROUPS to GROUPS
      .add(3611, "Add 'group_uuid' column on 'PERM_TEMPLATES_GROUPS' table", AddGroupUuidColumnToPermTemplatesGroups.class)
      .add(3612, "Populate 'group_uuid' for 'PERM_TEMPLATES_GROUPS'", PopulatePermTemplatesGroupsGroupUuid.class)

      // Migration of FK in QPROFILE_EDIT_GROUPS to GROUPS
      .add(3613, "Add 'group_uuid' column on 'QPROFILE_EDIT_GROUPS' table", AddGroupUuidColumnToQProfileEditGroups.class)
      .add(3614, "Populate 'group_uuid' for 'QPROFILE_EDIT_GROUPS'", PopulateQProfileEditGroupsGroupUuid.class)
      .add(3615, "Make 'group_uuid' column not nullable for 'QPROFILE_EDIT_GROUPS'", MakeQProfileEditGroupsGroupUuidNotNullable.class)
      .add(3616, "Drop index on 'group_id' column of 'QPROFILE_EDIT_GROUPS' table", DropIndexOnGroupIdOfQProfileEditGroupsTable.class)
      .add(3617, "Add index on 'group_uuid' column of 'QPROFILE_EDIT_GROUPS' table", AddIndexOnGroupUuidOfQProfileEditGroupsTable.class)

      // Finish migration of Groups
      .add(3618, "Drop primary key on 'ID' column of 'GROUPS' table", DropPrimaryKeyOnIdColumnOfGroupsTable.class)
      .add(3619, "Add primary key on 'UUID' column of 'GROUPS' table", AddPrimaryKeyOnUuidColumnOfGroupsTable.class)

      .add(3620, "Drop column 'group_id' of 'GROUP_ROLES' table", DropGroupIdColumnOfGroupRolesTable.class)
      .add(3621, "Drop column 'group_id' of 'GROUPS_USERS' table", DropGroupIdColumnOfGroupsUsersTable.class)
      .add(3622, "Drop column 'group_id' of 'ORGANIZATIONS' table", DropDefaultGroupIdColumnOfOrganizationsTable.class)
      .add(3623, "Drop column 'group_id' of 'PERM_TEMPLATES_GROUPS' table", DropGroupIdColumnOfPermTemplatesGroupsTable.class)
      .add(3624, "Drop column 'group_id' of 'QPROFILE_EDIT_GROUPS' table", DropGroupIdColumnOfQProfileEditGroupsTable.class)
      .add(3625, "Drop column 'ID' of 'GROUPS' table", DropIdColumnOfGroupsTable.class)

      // Migration of QUALITY_GATES_CONDITIONS FK to QUALITY_GATES, switch from qgate_id to qgate_uuid
      .add(3626, "Add 'qgate_uuid' column for quality gates conditions", AddQGateUuidColumnForQGateConditions.class)
      .add(3627, "Populate 'qgate_uuid' column for quality gates conditions", PopulateQGateUuidColumnForQGateConditions.class)
      .add(3628, "drop orphans quality gates conditions", DropOrphansQGateConditions.class)
      .add(3629, "Make 'qgate_uuid' column not nullable for quality gates conditions", MakeQGateUuidColumnNotNullableForQGateConditions.class)
      .add(3630, "Drop 'qgate_id' column for quality gates conditions", DropQGateIdColumnForQGateConditions.class)

      // Migrations of QUALITY_GATES table
      .add(3631, "Drop primary key on 'ID' column of 'QUALITY_GATES' table", DropPrimaryKeyOnIdColumnOfQGatesTable.class)
      .add(3632, "drop unique index on 'UUID' column of 'QUALITY_GATES' table", DropUniqueIndexOnUuidColumnOfQualityGatesTable.class)
      .add(3633, "Add primary key on 'UUID' column of 'QUALITY_GATES' table", AddPrimaryKeyOnUuidColumnOfQGatesTable.class)
      .add(3634, "Drop column 'ID' of 'QUALITY_GATES' table", DropIdColumnOfQGateTable.class)

      // Migration of FK in GROUPS_USERS to USERS
      .add(3635, "Add 'user_uuid' column on 'GROUPS_USERS' table", AddUserUuidColumnToGroupsUsers.class)
      .add(3636, "Populate 'user_uuid' for 'GROUPS_USERS'", PopulateGroupsUsersUserUuid.class)
      .add(3637, "Make 'user_uuid' column not nullable for 'GROUPS_USERS'", MakeGroupsUsersUserUuidColumnNotNullable.class)
      .add(3638, "Drop index on 'user_id' column of 'GROUPS_USERS' table", DropIndexOnUserIdOfGroupsUsersTable.class)
      .add(3639, "Add index on 'user_uuid' column of 'GROUPS_USERS' table", AddIndexOnUserUuidOfGroupsUsersTable.class)
      .add(3640, "Drop index on 'user_id', 'group_id' columns of 'GROUPS_USERS' table", DropUniqueIndexOnUserIdAndGroupIdOfGroupsUsersTable.class)
      .add(3641, "Add unique index on 'user_uuid', 'group_id' columns of 'GROUPS_USERS' table", AddUniqueIndexOnUserUuidAndGroupIdOfGroupsUsersTable.class)
      .add(3642, "Drop column on 'user_id' column of 'GROUPS_USERS' table", DropUserIdColumnOfGroupsUsersTable.class)

      // Migration of FK in ORGANIZATION_MEMBERS to USERS
      .add(3643, "Add 'user_uuid' column on 'ORGANIZATION_MEMBERS' table", AddUserUuidColumnToOrganizationMembers.class)
      .add(3644, "Populate 'user_uuid' for 'ORGANIZATION_MEMBERS'", PopulateOrganizationMembersUserUuid.class)
      .add(3645, "Make 'user_uuid' not-null for 'ORGANIZATION_MEMBERS'", MakeOrganizationMembersUserUuidColumnNotNullable.class)
      .add(3646, "Drop index on 'user_id' column of 'ORGANIZATION_MEMBERS' table", DropIndexOnUserIdOfOrganizationMembersTable.class)
      .add(3647, "Add index on 'user_uuid' column of 'ORGANIZATION_MEMBERS' table", AddIndexOnUserUuidOfOrganizationMembersTable.class)
      .add(3648, "Drop index on 'user_id', 'group_id' columns of 'ORGANIZATION_MEMBERS' table", DropPrimaryKeyOnUserIdAndOrganizationUuidOfOrganizationMembersTable.class)
      .add(3649, "Add PK on 'user_uuid', 'organization_uuid' columns of 'ORGANIZATION_MEMBERS' table", AddPrimaryKeyOnUserUuidAndOrganizationUuidColumnsOfUserRolesTable.class)
      .add(3650, "Drop column on 'user_id' column of 'ORGANIZATION_MEMBERS' table", DropUserIdColumnOfOrganizationMembersTable.class)

      // Migration of FK in PERM_TEMPLATES_USERS to USERS
      .add(3651, "Add 'user_uuid' column on 'PERM_TEMPLATES_USERS' table", AddUserUuidColumnToPermTemplatesUsers.class)
      .add(3652, "Populate 'user_uuid' for 'PERM_TEMPLATES_USERS'", PopulatePermTemplatesUsersUserUuid.class)
      .add(3653, "Make 'user_uuid' not-null for 'PERM_TEMPLATES_USERS'", MakePermTemplatesUsersUserUuidColumnNotNullable.class)
      .add(3654, "Drop column on 'user_id' column of 'PERM_TEMPLATES_USERS' table", DropUserIdColumnOfPermTemplatesUsersTable.class)

      // Migration of FK in PROPERTIES to USERS
      .add(3655, "Add 'user_uuid' column on 'PROPERTIES' table", AddUserUuidColumnToPropertiesUsers.class)
      .add(3656, "Populate 'user_uuid' for 'PROPERTIES'", PopulatePropertiesUserUuid.class)
      .add(3657, "Drop column on 'user_id' column of 'PROPERTIES' table", DropUserIdColumnOfPropertiesTable.class)

      // Migration of FK in QPROFILE_EDIT_USERS to USERS
      .add(3658, "Add 'user_uuid' column on 'QPROFILE_EDIT_USERS' table", AddUserUuidColumnToQProfileEditUsers.class)
      .add(3659, "Populate 'user_uuid' for 'QPROFILE_EDIT_USERS'", PopulateQProfileEditUsersUserUuid.class)
      .add(3660, "Make 'user_uuid' not-null for 'QPROFILE_EDIT_USERS'", MakeQProfileEditUsersUserUuidColumnNotNullable.class)
      .add(3661, "Drop unique index on 'user_id','qprofile_uuid' columns of 'QPROFILE_EDIT_USERS' table", DropUniqueIndexOnUserIdAndQProfileUuidOfQProfileEditUsersTable.class)
      .add(3662, "Add unique index on 'user_uuid','qprofile_uuid' columns of 'QPROFILE_EDIT_USERS' table", AddUniqueIndexOnUserUuidAndQProfileUuidOfQProfileEditUsersTable.class)
      .add(3663, "Drop column on 'user_id' column of 'QPROFILE_EDIT_USERS' table", DropUserIdColumnOfQProfileEditUsersTable.class)

      .add(3664, "Add 'user_uuid' column on 'USER_ROLES' table", AddUserUuidColumnToUserRoles.class)
      .add(3665, "Populate 'user_uuid' for 'USER_ROLES'", PopulateUserRolesUserUuid.class)
      .add(3666, "Drop unique index on 'user_id' column of 'USER_ROLES' table", DropIndexOnUserIdOfUserRolesTable.class)
      .add(3667, "Add unique index on 'user_uuid' columns of 'USER_ROLES' table", AddIndexOnUserUuidOfUserRolesTable.class)
      .add(3668, "Drop column on 'user_id' column of 'USER_ROLES' table", DropUserIdColumnOfUserRolesTable.class)

      .add(3669, "Drop unique index on 'user_id' column of 'USERS' table", DropUniqueIndexOnUuidColumnOfUsersTable.class)
      .add(3670, "Drop PK index on 'id' column of 'USERS' table", DropPrimaryKeyOnIdColumnOfUsersTable.class)
      .add(3671, "Add PK index on 'uuid' column of 'USERS' table", AddPrimaryKeyOnUuidColumnOfUsersTable.class)
      .add(3672, "Drop 'id' column of 'USERS' table", DropIdColumnOfUsersTable.class)

      // Migration of RULES table
      .add(3673, "Add 'uuid' column for 'RULES'", AddUuidAndTemplateUuidColumnsToRules.class)
      .add(3674, "Populate 'uuid' column for 'RULES'", PopulateRulesUuid.class)
      .add(3675, "Make 'uuid' column not nullable for 'RULES'", MakeRulesUuidColumnNotNullable.class)
      .add(3676, "Populate 'templateUuid' column for 'RULES'", PopulateRulesTemplateUuid.class)
      .add(3677, "Drop column 'templateId' column for 'RULES'", DropTemplateIdColumnOfRulesTable.class)
      // Migration of RULES_METADATA FK to RULES, switch from rule_id to rule_uuid
      .add(3678, "Add 'RULE_UUID' column for 'RULES_METADATA' table", AddRuleUuidColumnToRulesMetadataTable.class)
      .add(3679, "Populate 'RULE_UUID' column for 'RULES_METADATA' table", PopulateRulesMetadataRuleUuidColumn.class)
      .add(3680, "Make 'RULE_UUID' column not nullable for 'RULES_METADATA' table", MakeRulesMetadataRuleUuidColumnNotNullable.class)
      .add(3681, "Drop primary key on 'RULE_ID' column of 'RULES_METADATA' table", DropPrimaryKeyOnIdColumnOfRulesMetadataTable.class)
      .add(3682, "Add primary key on 'RULE_UUID' column of 'RULES_METADATA' table", AddPrimaryKeyOnUuidAndOrganizationUuidColumnOfRulesMetadataTable.class)
      .add(3683, "Drop column 'RULE_ID' of 'RULES_METADATA' table", DropRuleIdColumnOfRulesMetadataTable.class)
      // Migration of RULES_PARAMETERS FK to RULES, switch from rule_id to rule_uuid
      .add(3684, "Add 'RULE_UUID' column for 'RULES_PARAMETERS' table", AddRuleUuidColumnToRulesParametersTable.class)
      .add(3685, "Populate 'RULE_UUID' column for 'RULES_PARAMETERS' table", PopulateRulesParametersRuleUuidColumn.class)
      .add(3686, "Make 'RULE_UUID' column not nullable for 'RULES_PARAMETERS' table", MakeRulesParametersRuleUuidColumnNotNullable.class)
      .add(3687, "Drop indexes on 'RULE_ID' of 'RULES_PARAMETERS' table", DropIndexesOnRuleIdColumnOfRulesParametersTable.class)
      .add(3688, "Add indexes to 'RULES_PARAMETERS' table", AddIndexesToRulesParametersTable.class)
      .add(3689, "Drop column 'RULE_ID' of 'RULES_PARAMETERS' table", DropRuleIdColumnOfRulesParametersTable.class)
      // Migration of ACTIVE_RULES FK to RULES, switch from rule_id to rule_uuid
      .add(3690, "Add 'RULE_UUID' column for 'ACTIVE_RULES' table", AddRuleUuidColumnToActiveRulesTable.class)
      .add(3691, "Populate 'RULE_UUID' column for 'ACTIVE_RULES' table", PopulateActiveRulesRuleUuidColumn.class)
      .add(3692, "Make 'RULE_UUID' column not nullable for 'ACTIVE_RULES' table", MakeActiveRulesRuleUuidColumnNotNullable.class)
      .add(3693, "Drop indexes on 'RULE_ID' of 'ACTIVE_RULES' table", DropIndexOnRuleIdColumnOfActiveRulesTable.class)
      .add(3694, "Add indexes to 'ACTIVE_RULES' table", AddIndexToActiveRulesTable.class)
      .add(3695, "Drop column 'RULE_ID' of 'ACTIVE_RULES' table", DropRuleIdColumnOfActiveRulesTable.class)
      // Migration of DEPRECATED_RULE_KEYS FK to RULES, switch from rule_id to rule_uuid
      .add(3696, "Add 'RULE_UUID' column for 'DEPRECATED_RULE_KEYS' table", AddRuleUuidColumnToDeprecatedRuleKeysTable.class)
      .add(3697, "Populate 'RULE_UUID' column for 'DEPRECATED_RULE_KEYS' table", PopulateDeprecatedRuleKeysRuleUuidColumn.class)
      .add(3698, "Make 'RULE_UUID' column not nullable for 'DEPRECATED_RULE_KEYS' table", MakeDeprecatedRuleKeysRuleUuidColumnNotNullable.class)
      .add(3699, "Drop index on 'RULE_ID' of 'DEPRECATED_RULE_KEYS' table", DropIndexOnRuleIdColumnOfDeprecatedRuleKeysTable.class)
      .add(3700, "Add index to 'DEPRECATED_RULE_KEYS' table", AddIndexToDeprecatedRuleKeysTable.class)
      .add(3701, "Drop column 'RULE_ID' of 'DEPRECATED_RULE_KEYS' table", DropRuleIdColumnOfDeprecatedRuleKeysTable.class)
      // Migration of ISSUE FK to RULES, switch from rule_id to rule_uuid
      .add(3702, "Add 'RULE_UUID' column for 'ISSUES' table", AddRuleUuidColumnToIssuesTable.class)
      .add(3703, "Populate 'RULE_UUID' column for 'ISSUES' table", PopulateIssuesRuleUuidColumn.class)
      .add(3704, "Drop index on 'RULE_ID' of 'ISSUES' table", DropIndexOnRuleIdColumnOfIssuesTable.class)
      .add(3705, "Add index to 'ISSUES' table", AddIndexToIssuesTable.class)
      .add(3706, "Drop column 'RULE_ID' of 'ISSUES' table", DropRuleIdColumnOfIssuesTable.class)
      // continue with RULES table cleanup
      .add(3707, "Drop primary key on 'ID' column of 'RULES' table", DropPrimaryKeyOnIdColumnOfRulesTable.class)
      .add(3708, "Add primary key on 'UUID' column of 'RULES' table", AddPrimaryKeyOnUuidColumnOfRulesTable.class)
      .add(3709, "Drop column 'ID' of 'RULES' table", DropIdColumnOfRulesTable.class)

    ;
  }
}
